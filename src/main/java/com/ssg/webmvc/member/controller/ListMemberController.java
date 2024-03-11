package com.ssg.webmvc.member.controller;

import com.ssg.webmvc.member.dto.MemberDTO;
import com.ssg.webmvc.member.service.MemberService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listmemberController", urlPatterns = "/member/listMembers.do")

public class ListMemberController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ListMemberController doGet 메소드 실행 ");
        try {
            List<MemberDTO> memberDTOList = memberService.list();

            request.setAttribute("memberDTOList", memberDTOList);
            request.getRequestDispatcher("/WEB-INF/member/listmembers.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}

