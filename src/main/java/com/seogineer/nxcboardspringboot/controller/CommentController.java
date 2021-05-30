package com.seogineer.nxcboardspringboot.controller;

import com.seogineer.nxcboardspringboot.domain.dto.request.CommentCreateRequest;
import com.seogineer.nxcboardspringboot.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CommentController {

    private CommentService commentService;

    //목록 조회
//    @GetMapping("/comment")
//    public ResponseEntity<?> readAll(@RequestParam(defaultValue = "0") int start){
//        return new ResponseEntity<PagingRequest>(commentService.readAll(start), HttpStatus.OK);
//    }

    //등록
    @PostMapping("/comment/{id}")
    public ResponseEntity<?> create(@PathVariable Long id, @RequestBody CommentCreateRequest dto){
        return new ResponseEntity<Long>(commentService.create(id, dto), HttpStatus.CREATED);
    }

    //수정
//    @PutMapping("/comment/{id}")
//    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CommentUpdateRequest dto){
//        return new ResponseEntity<Long>(commentService.update(id, dto), HttpStatus.CREATED);
//    }

    //삭제
//    @DeleteMapping("/comment/{id}")
//    public ResponseEntity<?> delete(@PathVariable Long id) {
//        commentService.delete(id);
//        return new ResponseEntity<Long>(id, HttpStatus.NO_CONTENT);
//    }

}
