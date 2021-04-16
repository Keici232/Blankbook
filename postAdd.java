package Beans;

public class postAdd {
	
	private int addPost_id;
	private String post;
	private String tag;
	
	
	public int getaddPost_id() {
		return addPost_id;
	}
	
	public void setaddPost_id(int addPost_id) {
		this.addPost_id = addPost_id;
	}
	
	public String getPost() {
		return post;
	}
	
	public void setPost(String post) {
		this.post = post;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}

	
	@Override
	public String toString() {
		return "postAdd [addPost_id=" + addPost_id + ", post=" + post + ", tag=" + tag + "]";
	}

}
