package com.seogineer.nxcboardspringboot.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardSimpleResponse {

    private Long boardId;

    private String title;

    private String content;

    private String author;

}
