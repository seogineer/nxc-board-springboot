package com.seogineer.nxcboardspringboot.service;

import com.seogineer.nxcboardspringboot.domain.dto.PostsSaveRequestDto;
import com.seogineer.nxcboardspringboot.domain.entity.Posts;
import com.seogineer.nxcboardspringboot.domain.repository.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {
    @Autowired
    private PostsService postsService;
    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_posts테이블에_저장된다(){
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title("테스트 제목")
                .content("테스트 테스트 테스트")
                .author("테스터")
                .isTop(false)
                .build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getIsTop()).isFalse();
    }

    @Test
    public void posts테이블을_전체조회한다(){
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title("테스트 제목")
                .content("테스트 테스트 테스트")
                .author("테스터")
                .isTop(false)
                .build();

        //when
        for(int i = 0; i < 10; i++){
            postsService.save(dto);
        }

        //then
        List<Posts> postsList = postsRepository.findAll();
        assertEquals(10, postsList.size());
    }
}
