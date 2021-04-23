package com.seogineer.nxcboardspringboot.domain.dto;

import com.seogineer.nxcboardspringboot.domain.entity.Posts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostsSimpleResponseDto {
    private Long postId;
    private String title;
    private String content;
    private String author;
}
