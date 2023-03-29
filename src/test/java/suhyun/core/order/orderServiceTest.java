package suhyun.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import suhyun.core.member.Grade;
import suhyun.core.member.Member;
import suhyun.core.member.MemberService;
import suhyun.core.member.MemberServiceImpl;

public class orderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.vip);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
