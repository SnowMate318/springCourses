package hello.core.member;

import hello.core.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService(); // 여긴 memberServiceImpl이 들어가있겠지

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //@Bean 이라된걸 다 관리해줌
        //AppConfig에 있는 설정 정보를가지고 @Bean을 스프링 컨테이너에서 다 관리해줌

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        // "memberService" -> 네임 파라미터: 함수 이름 기반으로 검색
        
        
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findByMember(1L);
        System.out.println("newMember = "+member.getName());
        System.out.println("findMember = "+findMember.getName());

    }
}
