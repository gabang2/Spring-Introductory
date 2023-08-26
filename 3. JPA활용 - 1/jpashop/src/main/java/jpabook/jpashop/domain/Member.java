package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id") // 연관관계의 주인
    private Long id;
    private String name;
    @Embedded // embedded또는 Embeddable 둘 중 하나만 쓰면 된다!
    private Address address;
    @OneToMany(mappedBy = "member") // 연관관계의 주인이 아니다.(난 거울일 뿐이야 ! 읽기 전용임)
    private List<Order> orders = new ArrayList<>();
}
