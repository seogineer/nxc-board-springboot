package com.seogineer.nxcboardspringboot.domain.dto;

import com.seogineer.nxcboardspringboot.domain.entity.Posts;
import lombok.*;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;
    private Boolean isTop;
}
