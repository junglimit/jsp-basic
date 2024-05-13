package com.jsp.chap04;

import com.jsp.entity.Dancer;
import com.jsp.repository.DancerJdbcRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/chap04/remove")
public class DancerRemoveSelvlet extends HttpServlet {

    private final DancerJdbcRepo repo = DancerJdbcRepo.getInstance();


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("삭제 요청 서버에 들어옴!");

        // 삭제대상 id 값 읽어오기
        String id = req.getParameter("id");
        System.out.println("삭제대상 id = " + id);

        // db에 삭제명령
        repo.delete(id);


        // /chap04/show-list 요청을 자동으로 보냄 ( 리다이렉션 )
        resp.sendRedirect("/chap04/show-list");

    }
}
