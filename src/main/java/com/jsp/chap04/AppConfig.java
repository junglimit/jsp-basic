package com.jsp.chap04;

import com.jsp.repository.DancerJdbcRepo;
import com.jsp.repository.DancerMemoryRepo;

public class AppConfig {


    // 메모리 DB가 필요한 상황
    public DancerMemoryRepo dancerMemoryRepo() {
        return DancerMemoryRepo.getInstance();
    }

    // 실제 DB가 필요한 상황
    public DancerJdbcRepo dancerJdbcRepo() {
        return DancerJdbcRepo.getInstance();
    }

    public AddNewDancerServlet addnewDancerServlet() {
        return new AddNewDancerServlet(dancerJdbcRepo());
    }
    public ShowDancerListServlet showDancerListServlet() {
        return new ShowDancerListServlet(dancerJdbcRepo());
    }
}
