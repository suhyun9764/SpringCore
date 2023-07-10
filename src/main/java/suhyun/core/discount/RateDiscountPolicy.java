package suhyun.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import suhyun.core.member.Grade;
import suhyun.core.member.Member;

@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.vip){
            return price*discountPercent/100;
        }else{
            return 0;
        }
    }
}
