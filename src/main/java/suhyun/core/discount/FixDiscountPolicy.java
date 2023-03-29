package suhyun.core.discount;

import suhyun.core.member.Grade;
import suhyun.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.vip) {
            return discountFixAmount;
        }
        else{
            return 0;
        }
    }
}
