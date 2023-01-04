package com.jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") // 상품 구분 타입
@Getter
@Setter
public class Book extends Item {

    private String author;
    private String isbn;
}
