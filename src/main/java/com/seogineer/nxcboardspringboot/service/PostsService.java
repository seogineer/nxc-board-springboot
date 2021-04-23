package com.seogineer.nxcboardspringboot.service;

import com.seogineer.nxcboardspringboot.domain.dto.*;
import com.seogineer.nxcboardspringboot.domain.entity.Posts;
import com.seogineer.nxcboardspringboot.domain.repository.PostsRepository;
import com.seogineer.nxcboardspringboot.utils.ModelMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public PagingRequest selectAll(int start) {
        return postsRepository.selectAll(start);
    }

    @Transactional
    public PostsResponseDto selectOne(Long id){
        Posts posts = postsRepository.findById(id)
                            .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 게시글이 존재하지 않습니다."));

        Posts prev = postsRepository.getPrev(posts);
        Posts next = postsRepository.getNext(posts);

        PostsResponseDto response = ModelMapperUtil.map(posts, PostsResponseDto.class);

        if(prev != null){
            response.setPrev(ModelMapperUtil.map(prev, PostsSimpleResponseDto.class));
        }

        if(next != null){
            response.setNext(ModelMapperUtil.map(next, PostsSimpleResponseDto.class));
        }

        return response;
    }

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getPostId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto dto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 게시글이 존재하지 않습니다."));
        posts.update(dto.getTitle(), dto.getContent(), dto.getIsTop());

        return id;
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 게시글이 존재하지 않습니다."));
        postsRepository.delete(posts);
    }

}
