package com.seogineer.nxcboardspringboot.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seogineer.nxcboardspringboot.domain.entity.Posts;
import lombok.RequiredArgsConstructor;

import static com.seogineer.nxcboardspringboot.domain.entity.QPosts.posts;

@RequiredArgsConstructor
public class PostsRepositoryImpl implements PostsRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Posts getPrev(Posts entity) {
        return queryFactory
                .selectFrom(posts)
                .where(
                    //posts.isDeleted.isFalse(),
                    //posts.isBlocked.isFalse(),

                    posts.postId.lt(entity.getPostId())
                )
                .orderBy(
                    posts.isTop.desc(),
                    posts.postId.desc()
                )
                .fetchFirst();
    }

    @Override
    public Posts getNext(Posts entity) {
        return queryFactory
                .selectFrom(posts)
                .where(
                    //posts.isDeleted.isFalse(),
                    //posts.isBlocked.isFalse(),

                    posts.postId.gt(entity.getPostId())
                )
                .orderBy(
                    posts.isTop.desc(),
                    posts.postId.asc()
                )
                .fetchFirst();
    }
}
