package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("순수 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        //호출될 때 마다 객체 생성
        MemberService memberService1 = appConfig.memberService();

        //호출될 때 마다 객체 생성
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2); // 참조가 다름

        assertNotSame(memberService1,memberService2);
    }

    @Test
    @DisplayName("싱글톤 객체 사용")
    void singletonTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        assertSame(singletonService1,singletonService2);
        // same -> == 같은 인스턴스냐
        // equal -> .equal 같은 값이냐
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void singletonContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //싱글톤으로 인스턴스 반환
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        //싱글톤으로 인스턴스 반환
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2); // 참조가 다름

        assertSame(memberService1,memberService2);
    }
}
