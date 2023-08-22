package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

public enum DeliveryState {
    READY,
    COMP
}
