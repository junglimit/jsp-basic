package com.jsp.repository;

import com.jsp.chap05.Person;
import com.jsp.entity.Dancer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 역할: 실제 데이터베이스에 댄서들을 CRUD (저장, 조회, 수정, 삭제)
// Model
public class DancerJdbcRepo implements DancerRepository {

    // 필요한 데이터
    private String username = "root"; // db 계정명
    private String password = "jmg78963"; // db 패스워드
    private String url = "jdbc:mariadb://localhost:3306/spring5"; // db url : 데이터베이스 설치 위치
    private String driverClassName = "org.mariadb.jdbc.Driver"; // db 벤더별 전용 커넥터 클래스

    private static DancerJdbcRepo repo = new DancerJdbcRepo();

    // 싱글톤 구현
    private DancerJdbcRepo() {
    }

    // 싱글객체를 리턴하는 메서드
    public static DancerJdbcRepo getInstance() {
        return repo;
    }


    // 댄서를 데이터베이스에 저장하는 기능
    public boolean save(Dancer dancer) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            Class.forName(driverClassName);


            String sql = "INSERT INTO tbl_dancer" + "(name,crew_name,dance_level)" + "VALUES (?,?,?)";


            PreparedStatement pstmt = conn.prepareStatement(sql);


            pstmt.setString(1, dancer.getName());
            pstmt.setString(2, dancer.getCrewName());
            pstmt.setString(3, dancer.getDanceLevel().toString());

            // 6. 실행 명령
            // INSERT, UPDATE, DELETE 같은 명령 사용
            pstmt.executeUpdate();
            return true;
            // 7. 데이터베이스 연결 해제


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // 댄서리스트 반환기능
    public List<Dancer> retrieve() {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            Class.forName(driverClassName);

            String sql = "SELECT * FROM tbl_dancer";

            // SQL 실행 객체 생성
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // ? 채우기

            // 실행 명령 - SELECT 는 다른 메서드 사용
            // ResultSet : SELECT 의 결과집합 표를 가져옴
            ResultSet rs = pstmt.executeQuery();

            List<Dancer> dancerList = new ArrayList<>();
            // ResultSet 데이터 가져오기
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String crewName = rs.getString("crew_name");
                String danceLevel = rs.getString("dance_level");

                Dancer dancer = new Dancer();
                dancer.setId(id);
                dancer.setName(name);
                dancer.setCrewName(crewName);
                dancer.setDanceLevel(Dancer.DanceLevel.valueOf(danceLevel));

                dancerList.add(dancer);
            }
            return dancerList;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void delete(String id) {

        try(Connection conn = DriverManager.getConnection(url, username, password)) {

            Class.forName(driverClassName);

            String sql = "DELETE FROM tbl_dancer WHERE id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            pstmt.executeUpdate();


        } catch (Exception e){

        }
    }
}

