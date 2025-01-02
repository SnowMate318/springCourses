package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;
    @BeforeEach
    public void beforeEach(){  // 테스트 개수만큼 돌림
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    //MemberService memberService = new MemberServiceImpl(); // 좋은 설계 아님, DIP 위반

    @Test
    void join() {

        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findByMember(1L);

        //then
        Assertions.assertEquals(member, findMember);

    }

}
