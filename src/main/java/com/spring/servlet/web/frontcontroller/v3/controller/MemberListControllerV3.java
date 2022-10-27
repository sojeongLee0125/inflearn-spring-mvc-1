package com.spring.servlet.web.frontcontroller.v3.controller;

import com.spring.servlet.domain.member.Member;
import com.spring.servlet.domain.member.MemberRepository;
import com.spring.servlet.web.frontcontroller.ModelView;
import com.spring.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);

        return mv;
    }
}
