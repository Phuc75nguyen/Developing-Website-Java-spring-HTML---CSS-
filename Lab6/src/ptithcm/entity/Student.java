package ptithcm.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Students")
public class Student {
	@Id @GeneratedValue
	@Column(name ="Id")
	private Integer id;
	@Column(name ="Fullname")
	private String fullname;
	@Column(name ="Gender")
	private Boolean gender;
	@Column(name ="Birthday")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date birthday;
	@Column(name ="Mark")
	private Double mark;
	@ManyToOne
	@JoinColumn(name="majorId")
	private Major major;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(Integer id, String fullname, Boolean gender, Date birthday, Double maark, Major major) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.gender = gender;
		this.birthday = birthday;
		this.mark = maark;
		this.major = major;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Double getMark() {
		return mark;
	}
	public void setMark(Double maark) {
		this.mark = maark;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	
	
	
}
