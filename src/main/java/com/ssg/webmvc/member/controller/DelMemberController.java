package com.ssg.webmvc.member.controller;



import com.ssg.webmvc.member.dto.MemberDTO;
import com.ssg.webmvc.member.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="delMemberController",urlPatterns = "/member/delMember.do")
public class DelMemberController extends HttpServlet {
    MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDTO dto = MemberDTO.builder()
                .mid( request.getParameter("mid")).build();


        try {
            memberService.delete(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/member/listMembers.do");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
