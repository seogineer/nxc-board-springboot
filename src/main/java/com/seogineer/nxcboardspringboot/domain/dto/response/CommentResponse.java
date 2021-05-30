package com.seogineer.nxcboardspringboot.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {

    private Long commentId;

    private String content;

    private String author;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

}
