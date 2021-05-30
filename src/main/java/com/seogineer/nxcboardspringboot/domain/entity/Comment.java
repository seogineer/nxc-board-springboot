package com.seogineer.nxcboardspringboot.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
//@TableComment(value = "댓글", extend = "BaseEntity")
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@ColumnComment("댓글 일련번호")
    private Long commentId;

    @Column(columnDefinition = "TEXT", nullable = false)
    //@ColumnComment("내용")
    private String content;

    //@ColumnComment("작성자")
    private String author;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    public Comment (
            String content,
            String author,
            Board board
    ) {
        this.content = content;
        this.author = author;
        this.board = board;
    }

    public Comment createComment (
            String content,
            String author,
            Board board
    ) {
        return new Comment(
                content,
                author,
                board
        );
    }

    public void updateComment (String content) {
        this.content = content;
    }
}
