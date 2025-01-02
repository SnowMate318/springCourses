package hello.core.member;

import hello.core.AppConfig;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService(); // 여긴 memberServiceImpl이 들어가있겠지

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findByMember(1L);
        System.out.println("newMember = "+member.getName());
        System.out.println("findMember = "+findMember.getName());

    }
}
