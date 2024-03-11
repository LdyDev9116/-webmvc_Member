package com.ssg.webmvc.member.dao;

import com.ssg.webmvc.member.domain.MemberVO;
import com.ssg.webmvc.member.dto.MemberDTO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    public List<MemberVO> listMembers() throws Exception {
        List<MemberVO> memberVOList = new ArrayList<>();
        String sql = "select * from mvc_member";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            MemberVO vo = MemberVO.builder()
                    .mid(rs.getString("mid"))
                    .mpw(rs.getString("mpw"))
                    .mname(rs.getString("mname"))
                    .email(rs.getString("email"))
                    .signdate(rs.getDate("signdate").toLocalDate()).build();
            memberVOList.add(vo);
        }

        return memberVOList;
    }

    public MemberVO select(String mid) throws Exception {
        String SQL = "SELECT * FROM MVC_MEMBER WHERE MID = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(SQL);
        pstmt.setString(1, mid);
        @Cleanup ResultSet rs = pstmt.executeQuery();


        if (rs.next()) {
            MemberVO vo = MemberVO.builder()
                    .mid(rs.getString("mid"))
                    .mpw(rs.getString("mpw"))
                    .mname(rs.getString("mname"))
                    .email(rs.getString("email"))
                    .signdate(rs.getDate("signdate").toLocalDate()).build();

            return vo;
        } else return null;
    }

    public int insert(MemberVO vo) throws Exception {
        int result = 0;
        String sql = "INSERT INTO MVC_MEMBER(MID,MPW,MNAME,EMAIL) VALUES(?,?,?,?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, vo.getMid());
        pstmt.setString(2, vo.getMpw());
        pstmt.setString(3, vo.getMname());
        pstmt.setString(4, vo.getEmail());
        result = pstmt.executeUpdate();

        return result;
    }

    public int delete(MemberVO vo) throws Exception {
        int result = 0;
        String SQL = "DELETE FROM MVC_MEMBER WHERE mid = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(SQL);
        pstmt.setString(1, vo.getMid());
        result = pstmt.executeUpdate();

        return result;
    }

    public int update(MemberDTO dto) throws Exception {
        int result = 0;
        String SQL = "UPDATE MVC_MEMBER SET MNAME=?, MPW=?,EMAIL=? WHERE MID =?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(SQL);

        pstmt.setString(1, dto.getMname());
        pstmt.setString(2, dto.getMpw());
        pstmt.setString(3, dto.getEmail());
        pstmt.setString(4, dto.getMid());
        result = pstmt.executeUpdate();


        return result;
    }
}
