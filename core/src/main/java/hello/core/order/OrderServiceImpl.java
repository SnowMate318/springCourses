package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    //이게 설계가 잘됨?
    //디스카운트 난 모르겠어~ 니가 알아서 해줘
    //회원 난 모르겟어~ 니가 알아서 해줘
    // -> 단일책임의 원칙

    // 어떻게 DIP를 맞추냐
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; // 이렇게하면 클라이언트 코드(이 코드)를 변경할 필요가 없어지고 DIP 준수

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //인터페이스를 의존하도록 함
    /*
    * 그런데 이렇게하면 추가작업 필요(현재는 오류)
    *
    * */

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
