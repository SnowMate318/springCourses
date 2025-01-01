package hello.core.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice); // 최종오더결과 반환한다.


}
