package suhyun.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import suhyun.core.AppConfig;
import suhyun.core.member.Grade;
import suhyun.core.member.Member;
import suhyun.core.member.MemberService;
import suhyun.core.member.MemberServiceImpl;

public class orderServiceTest {
   MemberService memberService;
   OrderService orderService;
   @BeforeEach
   public void beforEach(){
       AppConfig appConfig = new AppConfig();
       memberService = appConfig.memberService();
       orderService = appConfig.orderService();
   }
    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.vip);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
