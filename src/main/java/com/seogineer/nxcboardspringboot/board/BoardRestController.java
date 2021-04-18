package com.seogineer.nxcboardspringboot.board;

import com.seogineer.nxcboardspringboot.domain.posts.PostsRepository;
import com.seogineer.nxcboardspringboot.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BoardRestController {

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String Hello(){
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }
}
