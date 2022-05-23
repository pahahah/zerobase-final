package com.example.zerobase.member.controller;

import com.example.zerobase.member.model.FindIdInput;
import com.example.zerobase.member.model.MemberInput;
import com.example.zerobase.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;

    @RequestMapping("/member/login")
    public String login(){
        return "member/login";
    }

    @GetMapping("/member/register")
    public String resgister(){
        return "member/register_student";
    }

    @PostMapping("/member/register")
    public String registerSubmit(Model model, HttpServletRequest request, MemberInput parameter){

        boolean result = memberService.register(parameter);
        model.addAttribute("result", result);

        return "member/register_success";
    }

    @GetMapping("/member/find-id")
    public String findId(){
        return "member/find_id";
    }

    @PostMapping("/member/find-id")
    public String findIdSubmit(Model model, FindIdInput parameter){
        boolean result = memberService.findId(parameter);
        model.addAttribute("result", result);

        return "member/find_id_result";
    }



}
