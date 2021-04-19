package com.seogineer.nxcboardspringboot.service;

import com.seogineer.nxcboardspringboot.domain.dto.PostsResponseDto;
import com.seogineer.nxcboardspringboot.domain.dto.PostsSaveRequestDto;
import com.seogineer.nxcboardspringboot.domain.dto.PostsUpdateRequestDto;
import com.seogineer.nxcboardspringboot.domain.entity.Posts;
import com.seogineer.nxcboardspringboot.domain.repository.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {

    private PostsRepository postsRepository;
    private EntityManager em;

    @Transactional
    public List<PostsResponseDto> selectAll(){

        TypedQuery<Posts> query = em.createQuery("SELECT p FROM posts", Posts.class);
        query.setFirstResult();


        return postsRepository.findAll()
                            .stream()
                            .map(PostsResponseDto::new)
                            .collect(Collectors.toList());
    }

    @Transactional
    public PostsResponseDto select(Long id){
        Posts posts = postsRepository.findById(id)
                            .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 게시글이 존재하지 않습니다."));
        return new PostsResponseDto(posts);
    }

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto dto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 게시글이 존재하지 않습니다."));

        posts.update(dto.getTitle(), dto.getContent());

        return id;
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 게시글이 존재하지 않습니다."));
        postsRepository.delete(posts);
    }


}
