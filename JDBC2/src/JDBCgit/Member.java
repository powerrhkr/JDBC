package JDBCgit;

public class Member {
	private String name ;
	private int age;
	private String phone;
	private String memNum;
	public Member(String name, int age, String phone, String memNum) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.memNum = memNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	
	
}
