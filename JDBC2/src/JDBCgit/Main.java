package JDBCgit;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("1.가입 2.조회");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("이름 ");
			String name = sc.next();
			System.out.println("나이 ");
			int age = sc.nextInt();
			System.out.println("전화번호 ");
			String phone = sc.next();
			System.out.println("멤버번호");
			String memNum = sc.next();
			Member mem = new Member(name, age, phone, memNum);
			MemberDAO dao = new MemberDAO();
			dao.insert(mem);
		} else if (choice == 2) {
			System.out.println("고객 번호를 입력하세요");
			String NO = sc.next();
			MemberDAO dao = new MemberDAO();
			Member m = dao.selectOne(NO);
			System.out.println("이름/나이/전화번호/고객번호");
			System.out.println(m.getName()+ "/" +m.getAge() +"/" +m.getPhone()+"/"+ m.getMemNum());
		}

	}

}
