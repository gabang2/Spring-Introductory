package hello.core.order;

public interface OrderService {

    Order createOrder(long memberId, String itemName, int itemPrice); // 1. 주문 생성
}
