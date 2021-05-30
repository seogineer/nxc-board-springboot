package com.seogineer.nxcboardspringboot.service;

import com.seogineer.nxcboardspringboot.domain.dto.request.CommentCreateRequest;
import com.seogineer.nxcboardspringboot.domain.entity.Board;
import com.seogineer.nxcboardspringboot.domain.entity.Comment;
import com.seogineer.nxcboardspringboot.domain.repository.BoardRepository;
import com.seogineer.nxcboardspringboot.domain.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class CommentService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

//    public PagingRequest readAll(int start) {
//        return boardRepository.readAll(start);
//    }

    public Long create(Long id, CommentCreateRequest dto){
        Board board = boardRepository.findById(id).get();

        return commentRepository.save(new Comment(
                dto.getContent(),
                dto.getAuthor(),
                board
        )).getCommentId();
    }

//    public Long update(Long id, CommentUpdateRequest dto){
//        Comment board = boardRepository.findById(id)
//                .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 게시글이 존재하지 않습니다."));
//        board.updateComment(dto.getTitle(), dto.getContent());
//
//        return id;
//    }

//    public void delete(Long id){
//        Comment board = boardRepository.findById(id)
//                .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 게시글이 존재하지 않습니다."));
//        boardRepository.delete(board);
//    }

}
