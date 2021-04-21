package com.seogineer.nxcboardspringboot.domain.dao;

import com.seogineer.nxcboardspringboot.domain.entity.Posts;
import com.seogineer.nxcboardspringboot.domain.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostsDao {

    private final PostsRepository repository;

    public Posts getPrev(Posts posts) {
        return repository.getPrev(posts);
    }

    public Posts getNext(Posts posts) {
        return repository.getNext(posts);
    }
}
