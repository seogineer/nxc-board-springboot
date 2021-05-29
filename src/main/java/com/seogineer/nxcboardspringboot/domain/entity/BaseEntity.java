package com.seogineer.nxcboardspringboot.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    //@ColumnComment("작성 날짜 시간")
    private LocalDateTime createdDate;

    @LastModifiedDate
    //@ColumnComment("수정 날짜 시간")
    public LocalDateTime modifiedDate;

}
