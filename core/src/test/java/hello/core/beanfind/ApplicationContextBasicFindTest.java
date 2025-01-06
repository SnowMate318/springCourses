package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig .class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Assertions.assertInstanceOf(MemberServiceImpl.class, memberService);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회") // 인터페이스로 조회함 -> 인터페이스의 구현체가 대상이됨
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);

        Assertions.assertInstanceOf(MemberServiceImpl.class, memberService);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회 x") // 인터페이스로 조회함 -> 인터페이스의 구현체가 대상이됨
    void findBeanByTypeX(){

        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("xxxxx",MemberService.class));

        //Assertions.assertInstanceOf(MemberServiceImpl.class, memberService);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        //인터페이스의 구현체(MemberServiceImpl)도 가능하다
        //하지만, 구현보다는 역할에 의존하는게 좋긴함(이걸 안쓰는게 좋긴함)

        Assertions.assertInstanceOf(MemberServiceImpl.class, memberService);
    }
}
