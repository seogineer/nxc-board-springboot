package com.seogineer.nxcboardspringboot.domain.dto.response;

import com.seogineer.nxcboardspringboot.domain.entity.Board;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponse {

    private Long boardId;

    private String title;

    private String content;

    private String author;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    private BoardSimpleResponse prev;

    private BoardSimpleResponse next;

    private List<CommentResponse> commentList = new ArrayList<>();

}
