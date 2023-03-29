package suhyun.core;

import suhyun.core.member.Grade;
import suhyun.core.member.Member;
import suhyun.core.member.MemberService;
import suhyun.core.member.MemberServiceImpl;
import suhyun.core.order.Order;
import suhyun.core.order.OrderService;
import suhyun.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.vip);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",10000 );

        System.out.println("order="+order);
        System.out.println("order="+order.caculatorPrice());

    }
}
