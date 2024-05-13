package com.jsp.repository;


import com.jsp.entity.Dancer;

import java.util.List;

// 추상화된 역할: Dancer 데이터를 CRUD
public interface DancerRepository {

    boolean save(Dancer dancer);

    List<Dancer> retrieve();

    void delete(String id);

}
