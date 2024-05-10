package com.jsp.chap04;

import com.jsp.entity.Dancer;
import com.jsp.repository.DancerJdbcRepo;
import com.jsp.repository.DancerMemoryRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// 역할 : 댄서 목록 조회 요청을 받아서 데이터베이스에 있는 댄서 정보를 가져온 후
//       HTML 을 찾아서 forwarding
@WebServlet("/chap04/show-list")
public class ShowDancerListServlet extends HttpServlet {

    private DancerJdbcRepo repo = DancerJdbcRepo.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 데이터베이스에 접근하여 댄서 목록 가져오기
        List<Dancer> dancerList = repo.retrieve();
//        System.out.println("dancerList = " + dancerList);

        // JSP 파일에게 보낼 데이터
        req.setAttribute("dancers", dancerList);

        // JSP 파일 열기
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/chap04/dancer-list.jsp");
        rd.forward(req, resp);
    }
}
