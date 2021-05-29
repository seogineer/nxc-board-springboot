package com.seogineer.nxcboardspringboot.domain.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seogineer.nxcboardspringboot.domain.dto.request.PagingRequest;
import com.seogineer.nxcboardspringboot.domain.dto.response.BoardResponse;
import com.seogineer.nxcboardspringboot.domain.entity.Board;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static com.seogineer.nxcboardspringboot.domain.entity.QPosts.posts;

@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private final int LIMIT = 10;

    @Override
    public PagingRequest selectAll(int start) {
        QueryResults<Board> results = queryFactory.selectFrom(posts)
                .offset(start).limit(LIMIT)
                .fetchResults();

        List<Board> list = results.getResults();
        List<BoardResponse> boardResponseList = list.stream().map(BoardResponse::new).collect(Collectors.toList());
        Long total = results.getTotal();

        return new PagingRequest(boardResponseList, total);
    }

    @Override
    public Board getPrev(Board entity) {
        return queryFactory
                .selectFrom(posts)
                .where(
                    posts.postId.lt(entity.getBoardId())
                )
                .orderBy(
                    posts.isTop.desc(),
                    posts.postId.desc()
                )
                .fetchFirst();
    }

    @Override
    public Board getNext(Board entity) {
        return queryFactory
                .selectFrom(posts)
                .where(
                    posts.postId.gt(entity.getBoardId())
                )
                .orderBy(
                    posts.isTop.desc(),
                    posts.postId.asc()
                )
                .fetchFirst();
    }
}
