package com.jpabook.jpashop.domain.item;

import com.jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 싱글 테이블: 한테이블에 다 때려박아(?)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item { //상속 관계 부모 클래스

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity; // 재고 수량

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<Category>();


}
