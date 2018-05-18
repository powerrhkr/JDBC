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
		// JDBC ����ϱ�
		// 1.����̹��ڵ�
		// Class�� �������� class�� ������ ������ �� �ִ� Ŭ���� ����ƽ���� ����Ǿ�����.
		try {
			// ���ܰ� ���� ���� �κ��� try�������� �����ִ� ����.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. �����ͺ��̽��� �����Ͽ� Connection ��ü ����
			con = DriverManager.getConnection(url, user, passWord);
			// 3. SQL���� �غ��ϱ�
			String sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, mem.getName());
			psmt.setInt(2, mem.getAge());
			psmt.setString(3, mem.getPhone());
			psmt.setString(4, mem.getMemNum());
			// 4.�����ϱ�
			int num = psmt.executeUpdate();
			// ���� ������Ʈ�� ���������ν� ������ ���� row�� ���� ��ȯ�Ѵ�.
			System.out.println(num);

		} catch (ClassNotFoundException e) {
			// ��ȣ�ȿ� �ִ� ��Ȳ�� �Ͼ���� ã�� �� �ֵ��� ���ִ±���
			// TODO Auto-generated catch block
			System.out.println("Ŭ������ ã�� �� �����ϴ�.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL������ ������ �߻�");
			e.printStackTrace();
		} finally {
			// 5. ���� ����
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
		// JDBC ����ϱ�
		// 1.����̹��ڵ�
		// Class�� �������� class�� ������ ������ �� �ִ� Ŭ���� ����ƽ���� ����Ǿ�����.
		try {
			// ���ܰ� ���� ���� �κ��� try�������� �����ִ� ����.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. �����ͺ��̽��� �����Ͽ� Connection ��ü ����
			con = DriverManager.getConnection(url, user, passWord);
			// 3. SQL���� �غ��ϱ�
			String sql = "SELECT * FROM MEMBER WHERE MEMNUM = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, nO);
			// 4.�����ϱ� ����Ʈ ����ô� �̺κ��� ��¦ �ٲ��.
			rs = psmt.executeQuery();

			// ���� ������Ʈ�� ���������ν� ������ ���� row�� ���� ��ȯ�Ѵ�.

			// 5. ResultSet ��ü���� ������ ������
			rs.next();
			// result.next()�� ���
			// ���������� �����ͼ� �����Ͱ� �ִ��� Ȯ���ϰ� ������ true���� ������ false ����
			String name = rs.getString(1);
			int age = rs.getInt(2);
			String phoneNum = rs.getString(3);
			String memNum2 = rs.getString(4);
			m = new Member(name,age,phoneNum,memNum2);

		} catch (ClassNotFoundException e) {
			// ��ȣ�ȿ� �ִ� ��Ȳ�� �Ͼ���� ã�� �� �ֵ��� ���ִ±���
			// TODO Auto-generated catch block
			System.out.println("Ŭ������ ã�� �� �����ϴ�.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL������ ������ �߻�");
			e.printStackTrace();
		} finally {
			// 5. ���� ����
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
