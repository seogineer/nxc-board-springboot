package com.seogineer.nxcboardspringboot.domain.dto.request;

import com.seogineer.nxcboardspringboot.domain.dto.response.BoardResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagingRequest {
    private List<BoardResponse> pageList;
    private Long total;
}
