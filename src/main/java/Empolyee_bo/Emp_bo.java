package Empolyee_bo;

public class Emp_bo {
	
	private int id;
	private String name;
	private String email;
	private String phone;
	private String pass;

	@Override
	public String toString() {
		return "Emp_bo [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", pass=" + pass + "]";
	}


	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	

}
