package com.seogineer.nxcboardspringboot.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
//@TableComment(value = "게시판", extend = "BaseTimeEntity")
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@ColumnComment("게시글 일련번호")
    private Long boardId;

    @Column(length = 500, nullable = false)
    //@ColumnComment("제목")
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT", nullable = false)
    //@ColumnComment("내용")
    private String content;

    //@ColumnComment("작성자")
    private String author;

    @Column(nullable = false)
    //@ColumnComment("상단 고정 여부")
    private Boolean isTop;

    public Board(String title, String content, String author, boolean isTop) {
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
