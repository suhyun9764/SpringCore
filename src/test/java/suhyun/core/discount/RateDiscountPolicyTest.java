package suhyun.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import suhyun.core.member.Grade;
import suhyun.core.member.Member;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10% 할인이 적용되어야 한다")
    void vip_o(){
        //given
        Member member = new Member(1L,"memberVip", Grade.vip);
        //when
        int discount = discountPolicy.discount(member,10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("vip가 아니면 할인이 적용되지 않아야 한다")
    void vip_x(){
        //given
        Member member = new Member(2L,"memberVip", Grade.Basic);
        //when
        int discount = discountPolicy.discount(member,10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}