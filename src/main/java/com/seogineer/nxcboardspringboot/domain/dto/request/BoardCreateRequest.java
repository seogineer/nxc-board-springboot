package com.seogineer.nxcboardspringboot.domain.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardCreateRequest {

    private String title;
    private String content;
    private String author;
    private Boolean isTop;

}
