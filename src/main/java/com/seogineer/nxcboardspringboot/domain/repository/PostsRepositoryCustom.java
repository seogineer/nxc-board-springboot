package com.seogineer.nxcboardspringboot.domain.repository;

import com.seogineer.nxcboardspringboot.domain.entity.Posts;

public interface PostsRepositoryCustom {
    Posts getPrev(Posts posts);
    Posts getNext(Posts posts);
}
