package com.seogineer.nxcboardspringboot.domain.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seogineer.nxcboardspringboot.domain.dto.request.PagingRequest;
import com.seogineer.nxcboardspringboot.domain.dto.response.BoardResponse;
import com.seogineer.nxcboardspringboot.domain.entity.Board;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static com.seogineer.nxcboardspringboot.domain.entity.QBoard.board;

@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private final int LIMIT = 10;

//    @Override
//    public PagingRequest readAll(int start) {
//        QueryResults<Board> results = queryFactory.selectFrom(board)
//                .offset(start).limit(LIMIT)
//                .fetchResults();
//
//        List<Board> list = results.getResults();
//        //List<BoardResponse> boardResponseList = list.stream().map(BoardResponse::new).collect(Collectors.toList());
//        List<BoardResponse> boardResponseList = new List<>();
//        Long total = results.getTotal();
//
//        return new PagingRequest(boardResponseList, total);
//    }

    @Override
    public Board getPrev(Board entity) {
        return queryFactory
                .selectFrom(board)
                .where(
                    board.boardId.lt(entity.getBoardId())
                )
                .orderBy(
                    board.boardId.desc()
                )
                .fetchFirst();
    }

    @Override
    public Board getNext(Board entity) {
        return queryFactory
                .selectFrom(board)
                .where(
                    board.boardId.gt(entity.getBoardId())
                )
                .orderBy(
                    board.boardId.asc()
                )
                .fetchFirst();
    }
}
