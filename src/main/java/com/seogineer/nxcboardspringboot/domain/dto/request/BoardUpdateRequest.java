package com.seogineer.nxcboardspringboot.domain.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardUpdateRequest {
    private String title;
    private String content;
    private Boolean isTop;
}
