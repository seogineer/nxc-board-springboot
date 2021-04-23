package com.seogineer.nxcboardspringboot.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagingRequest {
    private List<PostsResponseDto> pageList;
    private Long total;
}
