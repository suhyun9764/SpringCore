package suhyun.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import suhyun.core.AppConfig;
import suhyun.core.member.MemberService;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회 : 호출할 때 마다 객체를 생성

        MemberService memberService = appConfig.memberService();
        //2. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 참조값이 다른 것을 확인
        System.out.println("service :"+memberService);
        System.out.println("service1 : "+memberService1);

        // memberService != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService instance = SingletonService.getInstance();
        SingletonService instance1 = SingletonService.getInstance();

        System.out.println("singletonService : "+instance);
        System.out.println("singletonService : "+instance1);

        Assertions.assertThat(instance).isSameAs(instance1);

    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        //AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


        MemberService memberService = ac.getBean("memberService",MemberService.class);
        MemberService memberService1 = ac.getBean("memberService",MemberService.class);

        System.out.println("service :"+memberService);
        System.out.println("service1 : "+memberService1);

        // memberService != memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService);
    }

}
