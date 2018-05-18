package JDBCgit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	public void insert(Member mem) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String passWord = "test";
		Connection con = null;
		PreparedStatement psmt = null;
		// JDBC 사용하기
		// 1.드라이버코딩
		// Class는 내가가진 class의 정보를 가져올 수 있는 클래스 스태틱으로 선언되어있음.
		try {
			// 예외가 날것 같은 부분을 try문장으로 묶어주는 역할.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 데이터베이스와 연결하여 Connection 객체 연기
			con = DriverManager.getConnection(url, user, passWord);
			// 3. SQL문장 준비하기
			String sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, mem.getName());
			psmt.setInt(2, mem.getAge());
			psmt.setString(3, mem.getPhone());
			psmt.setString(4, mem.getMemNum());
			// 4.실행하기
			int num = psmt.executeUpdate();
			// 내가 업데이트를 실행함으로써 영향을 받은 row의 수를 반환한다.
			System.out.println(num);

		} catch (ClassNotFoundException e) {
			// 괄호안에 있는 상황이 일어났을때 찾을 수 있도록 해주는구문
			// TODO Auto-generated catch block
			System.out.println("클래스를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL실행중 문제가 발생");
			e.printStackTrace();
		} finally {
			// 5. 연결 끊기
			try {
				psmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public Member selectOne(String nO) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String passWord = "test";
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Member m = null;
		// JDBC 사용하기
		// 1.드라이버코딩
		// Class는 내가가진 class의 정보를 가져올 수 있는 클래스 스태틱으로 선언되어있음.
		try {
			// 예외가 날것 같은 부분을 try문장으로 묶어주는 역할.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 데이터베이스와 연결하여 Connection 객체 연기
			con = DriverManager.getConnection(url, user, passWord);
			// 3. SQL문장 준비하기
			String sql = "SELECT * FROM MEMBER WHERE MEMNUM = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, nO);
			// 4.실행하기 셀렉트 실행시는 이부분이 살짝 바뀐다.
			rs = psmt.executeQuery();

			// 내가 업데이트를 실행함으로써 영향을 받은 row의 수를 반환한다.

			// 5. ResultSet 객체에서 데이터 꺼내기
			rs.next();
			// result.next()의 기능
			// 다음행으로 내려와서 데이터가 있는지 확인하고 있으면 true리턴 없으면 false 리턴
			String name = rs.getString(1);
			int age = rs.getInt(2);
			String phoneNum = rs.getString(3);
			String memNum2 = rs.getString(4);
			m = new Member(name,age,phoneNum,memNum2);

		} catch (ClassNotFoundException e) {
			// 괄호안에 있는 상황이 일어났을때 찾을 수 있도록 해주는구문
			// TODO Auto-generated catch block
			System.out.println("클래스를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL실행중 문제가 발생");
			e.printStackTrace();
		} finally {
			// 5. 연결 끊기
			try {
				if (psmt != null)
					psmt.close();
				if (con != null)
					con.close();
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return m;
	}

}
