package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmounts = 1000;

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP){ //test -> 커맨드 쉬프트 t
            return discountFixAmounts;
        }

        return 0;
    }
}
