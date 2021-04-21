package com.seogineer.nxcboardspringboot.service;

import com.seogineer.nxcboardspringboot.domain.dao.PostsDao;
import com.seogineer.nxcboardspringboot.domain.dto.PostsResponseDto;
import com.seogineer.nxcboardspringboot.domain.dto.PostsSaveRequestDto;
import com.seogineer.nxcboardspringboot.domain.dto.PostsSimpleResponseDto;
import com.seogineer.nxcboardspringboot.domain.dto.PostsUpdateRequestDto;
import com.seogineer.nxcboardspringboot.domain.entity.Posts;
import com.seogineer.nxcboardspringboot.domain.repository.PostsRepository;
import com.seogineer.nxcboardspringboot.utils.ModelMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {

    private PostsDao postsDao;

    private PostsRepository postsRepository;

    private EntityManager em;

    private final int LIMIT = 10;

    @Transactional
    public List<PostsResponseDto> selectAll(int start){
        List<Posts> postsList = em.createQuery("SELECT p FROM Posts p", Posts.class)
                                                                        .setFirstResult(start)
                                                                        .setMaxResults(LIMIT)
                                                                        .getResultList();

        return postsList.stream().map(PostsResponseDto::new).collect(Collectors.toList());

        /*
        return postsRepository.findAll()
                            .stream()
                            .map(PostsResponseDto::new)
                            .collect(Collectors.toList());
        */
    }

    @Transactional
    public PostsResponseDto selectOne(Long id){
        Posts posts = postsRepository.findById(id)
                            .orElseThrow(() -> new IllegalAccessError("[id=" + id + "] 해당 게시글이 존재하지 않습니다."));

        Posts prev = postsDao.getPrev(posts);
        Posts next = postsDao.getNext(posts);

        PostsResponseDto response = ModelMapperUtil.map(posts, PostsResponseDto.class);
        response.setPrev(ModelMapperUtil.map(prev, PostsSimpleResponseDto.class));
        response.setNext(ModelMapperUtil.map(next, PostsSimpleResponseDto.class));

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
