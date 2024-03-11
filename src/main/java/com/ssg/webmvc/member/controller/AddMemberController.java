package com.ssg.webmvc.member.controller;


import com.ssg.webmvc.member.dto.MemberDTO;
import com.ssg.webmvc.member.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name="addMemberController", urlPatterns = "/member/addMember.do")
public class AddMemberController extends HttpServlet {
    MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.getRequestDispatcher("/WEB-INF/member/addmember.jsp")
             .forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("addMemberController doPost...");
        MemberDTO memberDTO = MemberDTO.builder()
                .mid(request.getParameter("mid"))
                .mpw(request.getParameter("mpw"))
                .mname(request.getParameter("mname"))
                .email(request.getParameter("email")).build();
        log.info(memberDTO);
        try {

           log.info(memberService.insert(memberDTO));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("/member/listMembers.do");
    }
}
