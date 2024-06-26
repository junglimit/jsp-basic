package com.jsp.chap04;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 역할 : 댄서 등록화면 요청시 해당 html파일을 열기만 해주는 역할
@WebServlet("/chap04/dancer/form")
public class DancerFormRequestServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // view에게 화면처리 위임
        // forwarding : 화면파일을 찾아서 열어주는 개념
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/chap04/register.jsp");
        rd.forward(req, resp);

    }
}
