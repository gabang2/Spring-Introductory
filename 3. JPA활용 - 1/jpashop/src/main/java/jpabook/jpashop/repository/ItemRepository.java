package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item); // 신규로 등록(아이디 없으니까
        } else {
            em.merge(item); // 기존에 있는 것 등록
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id); // 단건
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList(); // 여러 건 -> JPQA
    }
}
