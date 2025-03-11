package ptithcm.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Records")
public class Record {
@Id
	
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;
	
	@Column(name = "Type")
	private Boolean type;
	
	@Column(name = "Reason")
	private String reason;
	
	@Column(name = "Date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "StaffId") 
	private Staff staffs;

	public Record() {
		// TODO Auto-generated constructor stub
	}

	public Record(BigInteger id, Boolean type, String reason, Date date, Staff staffs) {
		super();
		this.id = id;
		this.type = type;
		this.reason = reason;
		this.date = date;
		this.staffs = staffs;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Staff getStaffs() {
		return staffs;
	}

	public void setStaffs(Staff staffs) {
		this.staffs = staffs;
	}
}
