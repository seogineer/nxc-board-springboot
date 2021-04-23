package com.seogineer.nxcboardspringboot.domain.repository;

import com.seogineer.nxcboardspringboot.domain.dto.PagingRequest;
import com.seogineer.nxcboardspringboot.domain.entity.Posts;
import org.springframework.data.domain.PageRequest;

public interface PostsRepositoryCustom {
    PagingRequest selectAll(int start);
    Posts getPrev(Posts posts);
    Posts getNext(Posts posts);
}
