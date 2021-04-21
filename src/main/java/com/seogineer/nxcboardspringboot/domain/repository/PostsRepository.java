package com.seogineer.nxcboardspringboot.domain.repository;

import com.seogineer.nxcboardspringboot.domain.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long>, PostsRepositoryCustom {
}