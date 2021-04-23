package com.seogineer.nxcboardspringboot.domain.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seogineer.nxcboardspringboot.domain.dto.PagingRequest;
import com.seogineer.nxcboardspringboot.domain.dto.PostsResponseDto;
import com.seogineer.nxcboardspringboot.domain.entity.Posts;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static com.seogineer.nxcboardspringboot.domain.entity.QPosts.posts;

@RequiredArgsConstructor
public class PostsRepositoryImpl implements PostsRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private final int LIMIT = 10;

    @Override
    public PagingRequest selectAll(int start) {
        QueryResults<Posts> results = queryFactory.selectFrom(posts)
                .offset(start).limit(LIMIT)
                .fetchResults();

        List<Posts> list = results.getResults();
        List<PostsResponseDto> PostsResponseDtoList = list.stream().map(PostsResponseDto::new).collect(Collectors.toList());
        Long total = results.getTotal();

        return new PagingRequest(PostsResponseDtoList, total);
    }

    @Override
    public Posts getPrev(Posts entity) {
        return queryFactory
                .selectFrom(posts)
                .where(
                    posts.postId.lt(entity.getPostId())
                )
                .orderBy(
                    posts.isTop.desc(),
                    posts.postId.desc()
                )
                .fetchFirst();
    }

    @Override
    public Posts getNext(Posts entity) {
        return queryFactory
                .selectFrom(posts)
                .where(
                    posts.postId.gt(entity.getPostId())
                )
                .orderBy(
                    posts.isTop.desc(),
                    posts.postId.asc()
                )
                .fetchFirst();
    }
}
