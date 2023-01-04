package com.jpabook.jpashop.domain;


import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable // 임베디드 타입은 자바 기본 생성자를  public or protected로 설정, protected가 더 안전하다.
@Getter
// 값 타입은 변경 불가능하게 설계.
// @Setter 를 제거하고, 생성자에서 값을 모두 초기화해서 변경 불가능한 클래스 생성
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address(){

    }

    public Address(String city, String street, String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
