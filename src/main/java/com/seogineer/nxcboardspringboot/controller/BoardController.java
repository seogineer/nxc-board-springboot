package com.seogineer.nxcboardspringboot.controller;

import com.seogineer.nxcboardspringboot.domain.dto.request.PagingRequest;
import com.seogineer.nxcboardspringboot.domain.dto.response.BoardResponse;
import com.seogineer.nxcboardspringboot.domain.dto.request.BoardCreateRequest;
import com.seogineer.nxcboardspringboot.domain.dto.request.BoardUpdateRequest;
import com.seogineer.nxcboardspringboot.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BoardController {

    private BoardService boardService;

    //목록 조회
//    @GetMapping("/board")
//    public ResponseEntity<?> readAll(@RequestParam(defaultValue = "0") int start){
//        return new ResponseEntity<PagingRequest>(boardService.readAll(start), HttpStatus.OK);
//    }

    //상세 조회
    @GetMapping("/board/{id}")
    public ResponseEntity<?> readOne(@PathVariable Long id) {
        return new ResponseEntity<BoardResponse>(boardService.readOne(id), HttpStatus.OK);
    }

    //등록
    @PostMapping("/board")
    public ResponseEntity<?> create(@RequestBody BoardCreateRequest dto){
        return new ResponseEntity<Long>(boardService.create(dto), HttpStatus.CREATED);
    }

    //수정
    @PutMapping("/board/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BoardUpdateRequest dto){
        return new ResponseEntity<Long>(boardService.update(id, dto), HttpStatus.CREATED);
    }

    //삭제
    @DeleteMapping("/board/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boardService.delete(id);
        return new ResponseEntity<Long>(id, HttpStatus.NO_CONTENT);
    }

}
