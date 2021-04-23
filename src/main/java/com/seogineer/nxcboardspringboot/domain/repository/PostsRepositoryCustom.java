package com.seogineer.nxcboardspringboot.domain.repository;

import com.seogineer.nxcboardspringboot.domain.dto.PageRequest;
import com.seogineer.nxcboardspringboot.domain.entity.Posts;

public interface PostsRepositoryCustom {
    PageRequest selectAll(int start);
    Posts getPrev(Posts posts);
    Posts getNext(Posts posts);
}
