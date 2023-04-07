package suhyun.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import suhyun.core.member.Grade;
import suhyun.core.member.Member;
import suhyun.core.member.MemberService;
import suhyun.core.member.MemberServiceImpl;
import suhyun.core.order.Order;
import suhyun.core.order.OrderService;
import suhyun.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
       // AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.vip);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",20000 );

        System.out.println("order="+order);
        System.out.println("order="+order.caculatorPrice());

    }
}
