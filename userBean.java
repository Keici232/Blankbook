package Beans;


public class userBean {
	
	private String fullname;
	private String password;
	
	
	public String getFullname() {
		return fullname;
	}
	
	
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "userBean [fullname=" + fullname + ", password=" + password + "]";
	}
	
	

}
