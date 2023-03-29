package suhyun.core;

import suhyun.core.member.Grade;
import suhyun.core.member.Member;
import suhyun.core.member.MemberService;
import suhyun.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA",Grade.vip);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member ="+member.getName());
        System.out.println("find member ="+findMember.getName());
    }
}
