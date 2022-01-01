package com.customer.customerdemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name="customerdetails",schema="public")
public class CustomerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable= false,name="id")
	private Long id;
	
	@Column(nullable = false,name="cust_name")
	private String cust_name;
	
	@Column(nullable = false,name="site_loc")
	private String site_loc;
	
	@Column(nullable = false,name="cust_con_person")
	private String cust_con_person;
	
	@Column(nullable = false,name="cust_mail_id")
	private String cust_mail_id;
	
	@Column(nullable = false,name="cust_cont_no")
	private String cust_cont_no;
	
	@Column(nullable = false,name="trans_mail_id")
	private String trans_mail_id;
	
	@Column(nullable = false,name="trans_name")
	private String trans_name;
	
	@Column(nullable = false,name="status")
	private String status;
	
	@Column(name="is_deleted",insertable=false)
	private Boolean isDeleted = false;
	
	@Column(name="created_at",insertable=false,updatable=false)
	@CreatedDate
    @Temporal(TIMESTAMP)
	private Date createdDate;
	
	@Column(name="updated_at")
	@LastModifiedDate
    @Temporal(TIMESTAMP)
    private Date lastModifiedDate;
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getSite_loc() {
		return site_loc;
	}

	public void setSite_loc(String site_loc) {
		this.site_loc = site_loc;
	}

	public String getCust_con_person() {
		return cust_con_person;
	}

	public void setCust_con_person(String cust_con_person) {
		this.cust_con_person = cust_con_person;
	}

	public String getCust_mail_id() {
		return cust_mail_id;
	}

	public void setCust_mail_id(String cust_mail_id) {
		this.cust_mail_id = cust_mail_id;
	}

	public String getCust_cont_no() {
		return cust_cont_no;
	}

	public void setCust_cont_no(String cust_cont_no) {
		this.cust_cont_no = cust_cont_no;
	}

	public String getTrans_mail_id() {
		return trans_mail_id;
	}

	public void setTrans_mail_id(String trans_mail_id) {
		this.trans_mail_id = trans_mail_id;
	}

	public String getTrans_name() {
		return trans_name;
	}

	public void setTrans_name(String trans_name) {
		this.trans_name = trans_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}