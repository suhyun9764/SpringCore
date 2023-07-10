package suhyun.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import suhyun.core.discount.FixDiscountPolicy;
import suhyun.core.member.Grade;
import suhyun.core.member.Member;
import suhyun.core.member.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"name", Grade.vip));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository,new FixDiscountPolicy());
        Order order = orderService.createOrder(1L,"itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}