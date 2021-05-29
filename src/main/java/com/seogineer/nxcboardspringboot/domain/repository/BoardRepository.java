package com.seogineer.nxcboardspringboot.domain.repository;

import com.seogineer.nxcboardspringboot.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {
}