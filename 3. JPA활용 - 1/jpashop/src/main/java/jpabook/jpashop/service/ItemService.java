package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    /**
     * 상품 등록
     */
    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    /**
     * 상품 수정
     */
    @Transactional
    public void updateItem(Long itemId, String name, int stockQuantity, int price) {
        Item item = itemRepository.findOne(itemId);
        item.setName(name);
        item.setStockQuantity(stockQuantity);
        item.setPrice(price);
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
