package com.seogineer.nxcboardspringboot.service;

import com.seogineer.nxcboardspringboot.domain.dto.request.PagingRequest;
import com.seogineer.nxcboardspringboot.domain.dto.request.BoardCreateRequest;
import com.seogineer.nxcboardspringboot.domain.dto.request.BoardUpdateRequest;
import com.seogineer.nxcboardspringboot.domain.dto.response.BoardResponse;
import com.seogineer.nxcboardspringboot.domain.dto.response.BoardSimpleResponse;
import com.seogineer.nxcboardspringboot.domain.dto.response.CommentResponse;
import com.seogineer.nxcboardspringboot.domain.entity.Board;
import com.seogineer.nxcboardspringboot.domain.entity.Comment;
import com.seogineer.nxcboardspringboot.domain.repository.BoardRepository;
import com.seogineer.nxcboardspringboot.domain.repository.CommentRepository;
import com.seogineer.nxcboardspringboot.utils.ModelMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

//    public PagingRequest readAll(int start) {
//        return boardRepository.readAll(start);
//    }

    public BoardResponse readOne(Long id){
        Board board = boardRepository.findById(id)
                            .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 게시글이 존재하지 않습니다."));

        Board prev = boardRepository.getPrev(board);
        Board next = boardRepository.getNext(board);

        BoardResponse response = ModelMapperUtil.map(board, BoardResponse.class);

        if(prev != null){
            response.setPrev(ModelMapperUtil.map(prev, BoardSimpleResponse.class));
        }

        if(next != null){
            response.setNext(ModelMapperUtil.map(next, BoardSimpleResponse.class));
        }

        List<CommentResponse> commentResponseList = new ArrayList<>();

        List<Comment> commentList = commentRepository.findByBoard(board);
        for(Comment comment : commentList){
            CommentResponse commentResponse = new CommentResponse();

            commentResponse.setCommentId(comment.getCommentId());
            commentResponse.setContent(comment.getContent());
            commentResponse.setAuthor(comment.getAuthor());
            commentResponse.setCreatedDate(comment.getCreatedDate());
            commentResponse.setModifiedDate(comment.getModifiedDate());

            commentResponseList.add(commentResponse);
        }

        response.setCommentList(commentResponseList);

        return response;
    }

    public Long create(BoardCreateRequest dto){
        return boardRepository.save(new Board(
                dto.getTitle(),
                dto.getContent(),
                dto.getAuthor()
        )).getBoardId();
    }

    public Long update(Long id, BoardUpdateRequest dto){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 게시글이 존재하지 않습니다."));
        board.updateBoard(dto.getTitle(), dto.getContent());

        return id;
    }

    public void delete(Long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 게시글이 존재하지 않습니다."));
        boardRepository.delete(board);
    }

}
