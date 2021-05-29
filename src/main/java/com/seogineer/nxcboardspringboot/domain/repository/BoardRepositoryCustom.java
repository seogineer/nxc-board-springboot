package com.seogineer.nxcboardspringboot.domain.repository;

import com.seogineer.nxcboardspringboot.domain.dto.request.PagingRequest;
import com.seogineer.nxcboardspringboot.domain.entity.Board;

public interface BoardRepositoryCustom {
    PagingRequest selectAll(int start);
    Board getPrev(Board board);
    Board getNext(Board board);
}
