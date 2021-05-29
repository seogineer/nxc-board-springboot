package com.seogineer.nxcboardspringboot.domain.dto.response;

import com.seogineer.nxcboardspringboot.domain.entity.Board;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Data
@NoArgsConstructor
public class BoardResponse {

    private Long postId;
    private String title;
    private String content;
    private String author;
    private String createdDate;
    private String modifiedDate;
    private Boolean isTop;
    private BoardSimpleResponse prev;
    private BoardSimpleResponse next;

    public BoardResponse(Board entity) {
        postId = entity.getBoardId();
        title = entity.getTitle();
        content = entity.getContent();
        author = entity.getAuthor();
        createdDate = toStringDateTime(entity.getCreatedDate());
        modifiedDate = toStringDateTime(entity.getModifiedDate());
        isTop = entity.getIsTop();
    }

    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
