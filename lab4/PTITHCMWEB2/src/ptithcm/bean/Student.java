package ptithcm.bean;

public class Student {
	private String name;
	private Double mark;
	private String major;

	public Student() {
// TODO Auto-generated constructor stub
	}

	public Student(String name, Double mark, String major) {
// TODO Auto-generated constructor stub
		this.setName(name);
		this.setMark(mark);
		this.setMajor(major);
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Double getMark() {
		return mark;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}