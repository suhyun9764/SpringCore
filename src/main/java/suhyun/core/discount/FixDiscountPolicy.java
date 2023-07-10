package suhyun.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import suhyun.core.member.Grade;
import suhyun.core.member.Member;

@Component
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
