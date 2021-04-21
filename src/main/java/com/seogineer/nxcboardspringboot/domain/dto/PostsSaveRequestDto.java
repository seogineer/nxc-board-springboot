package com.seogineer.nxcboardspringboot.domain.dto;

import com.seogineer.nxcboardspringboot.domain.entity.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;
    private Boolean isTop;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author, boolean isTop) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.isTop = isTop;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .isTop(isTop)
                .build();
    }
}
