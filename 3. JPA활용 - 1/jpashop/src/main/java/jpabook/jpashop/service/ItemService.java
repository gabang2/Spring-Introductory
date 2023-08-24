package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    /**
     * 상품 등록
     */
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    /**
     * 상품 조회
     */
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findItemOne(Long id) {
        return itemRepository.findOne(id);
    }
}
