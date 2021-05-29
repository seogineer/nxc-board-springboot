package com.seogineer.nxcboardspringboot.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardSimpleResponse {
    private Long postId;
    private String title;
    private String content;
    private String author;
}
