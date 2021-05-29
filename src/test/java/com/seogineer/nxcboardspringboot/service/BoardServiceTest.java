package com.seogineer.nxcboardspringboot.service;

import com.seogineer.nxcboardspringboot.domain.dto.request.BoardCreateRequest;
import com.seogineer.nxcboardspringboot.domain.entity.Board;
import com.seogineer.nxcboardspringboot.domain.repository.BoardRepository;
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
public class BoardServiceTest {
    @Autowired
    private PostsService postsService;
    @Autowired
    private BoardRepository boardRepository;

    @After
    public void cleanup(){
        boardRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_posts테이블에_저장된다(){
        //given
        BoardCreateRequest dto = BoardCreateRequest.builder()
                .title("테스트 제목")
                .content("테스트 테스트 테스트")
                .author("테스터")
                .isTop(false)
                .build();

        //when
        postsService.save(dto);

        //then
        Board board = boardRepository.findAll().get(0);
        assertThat(board.getTitle()).isEqualTo(dto.getTitle());
        assertThat(board.getContent()).isEqualTo(dto.getContent());
        assertThat(board.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(board.getIsTop()).isFalse();
    }

    @Test
    public void posts테이블을_전체조회한다(){
        //given
        BoardCreateRequest dto = BoardCreateRequest.builder()
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
        List<Board> boardList = boardRepository.findAll();
        assertEquals(10, boardList.size());
    }
}
