package com.seogineer.nxcboardspringboot.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostsSimpleResponseDto {
    private Long postId;
    private String title;
    private String content;
    private String author;
}
