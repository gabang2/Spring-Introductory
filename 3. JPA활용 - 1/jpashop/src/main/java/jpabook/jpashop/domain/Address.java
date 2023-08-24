package jpabook.jpashop.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable // JPA 내장 타입 느낌(ENUM느낌)
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
    private String city;
    private String street;
    private String zip;

}
