package com.seogineer.nxcboardspringboot.controller;

import com.seogineer.nxcboardspringboot.domain.dto.request.PagingRequest;
import com.seogineer.nxcboardspringboot.domain.dto.response.BoardResponse;
import com.seogineer.nxcboardspringboot.domain.dto.request.BoardCreateRequest;
import com.seogineer.nxcboardspringboot.domain.dto.request.BoardUpdateRequest;
import com.seogineer.nxcboardspringboot.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BoardController {

    private PostsService postsService;

    //전체 조회
    @GetMapping("/posts")
    public ResponseEntity<?> selectAll(@RequestParam(defaultValue = "0") int start){
        return new ResponseEntity<PagingRequest>(postsService.selectAll(start), HttpStatus.OK);
    }

    //조회
    @GetMapping("/posts/{id}")
    public ResponseEntity<?> selectOne(@PathVariable Long id) {
        return new ResponseEntity<BoardResponse>(postsService.selectOne(id), HttpStatus.OK);
    }

    //등록
    @PostMapping("/posts")
    public ResponseEntity<?> save(@RequestBody BoardCreateRequest dto){
        return new ResponseEntity<Long>(postsService.save(dto), HttpStatus.CREATED);
    }

    //수정
    @PutMapping("/posts/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BoardUpdateRequest dto){
        return new ResponseEntity<Long>(postsService.update(id, dto), HttpStatus.CREATED);
    }

    //삭제
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        postsService.delete(id);
        return new ResponseEntity<Long>(id, HttpStatus.NO_CONTENT);
    }

}
