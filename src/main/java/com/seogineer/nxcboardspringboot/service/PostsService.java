package com.seogineer.nxcboardspringboot.service;

import com.seogineer.nxcboardspringboot.domain.dto.request.PagingRequest;
import com.seogineer.nxcboardspringboot.domain.dto.request.BoardCreateRequest;
import com.seogineer.nxcboardspringboot.domain.dto.request.BoardUpdateRequest;
import com.seogineer.nxcboardspringboot.domain.dto.response.BoardResponse;
import com.seogineer.nxcboardspringboot.domain.dto.response.BoardSimpleResponse;
import com.seogineer.nxcboardspringboot.domain.entity.Board;
import com.seogineer.nxcboardspringboot.domain.repository.BoardRepository;
import com.seogineer.nxcboardspringboot.utils.ModelMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PostsService {

    private final BoardRepository boardRepository;

    @Transactional
    public PagingRequest selectAll(int start) {
        return boardRepository.selectAll(start);
    }

    @Transactional
    public BoardResponse selectOne(Long id){
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

        return response;
    }

    @Transactional
    public Long save(BoardCreateRequest dto){
        return boardRepository.save(dto.toEntity()).getBoardId();
    }

    @Transactional
    public Long update(Long id, BoardUpdateRequest dto){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 게시글이 존재하지 않습니다."));
        board.update(dto.getTitle(), dto.getContent(), dto.getIsTop());

        return id;
    }

    @Transactional
    public void delete(Long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 게시글이 존재하지 않습니다."));
        boardRepository.delete(board);
    }

}
