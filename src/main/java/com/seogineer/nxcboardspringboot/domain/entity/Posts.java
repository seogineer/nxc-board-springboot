package com.seogineer.nxcboardspringboot.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long postId;

    @Column(length = 500, nullable = false)
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Column(nullable = false)
    private Boolean isTop;

    @Builder
    public Posts(String title, String content, String author, boolean isTop) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.isTop = isTop;
    }

    public void update (String title, String content, boolean isTop) {
        this.title = title;
        this.content = content;
        this.isTop = isTop;
    }
}
