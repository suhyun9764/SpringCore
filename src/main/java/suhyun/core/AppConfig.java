package suhyun.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import suhyun.core.discount.DiscountPolicy;
import suhyun.core.discount.FixDiscountPolicy;
import suhyun.core.discount.RateDiscountPolicy;
import suhyun.core.member.MemberService;
import suhyun.core.member.MemberServiceImpl;
import suhyun.core.member.MemoryMemberRepository;
import suhyun.core.order.OrderService;
import suhyun.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
