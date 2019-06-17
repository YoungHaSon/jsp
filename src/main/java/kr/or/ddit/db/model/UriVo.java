package kr.or.ddit.db.model;

public class UriVo {

	String uri;
	String classname;
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	@Override
	public String toString() {
		return "UriVo [uri=" + uri + ", classname=" + classname + "]";
	}
}
