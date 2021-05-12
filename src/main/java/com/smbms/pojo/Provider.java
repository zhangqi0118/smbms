package com.smbms.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Provider {
	
	private Integer id;   //id
	private String proCode; //供应商编码
	private String proName; //供应商名称
	private String proDesc; //供应商描述
	private String proContact; //供应商联系人
	private String proPhone; //供应商电话
	private String proAddress; //供应商地址
	private String proFax; //供应商传真
	private Integer createdBy; //创建者
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creationDate; //创建时间
	private Integer modifyBy; //更新者
	private Date modifyDate;//更新时间
	private String providerName;
	private List<Bill>billList;

	public List<Bill> getBillList() {
		return billList;
	}

	public void setBillList(List<Bill> billList) {
		this.billList = billList;
	}

	public Provider(Integer id, String proCode, String proName, String proDesc, String proContact, String proPhone, String proAddress, String proFax, Integer createdBy, Date creationDate, Integer modifyBy, Date modifyDate) {
		this.id = id;
		this.proCode = proCode;
		this.proName = proName;
		this.proDesc = proDesc;
		this.proContact = proContact;
		this.proPhone = proPhone;
		this.proAddress = proAddress;
		this.proFax = proFax;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}

	public Provider(Integer id, String proCode, String proName, String proDesc, String proContact, String proPhone, String proAddress, String proFax, Date creationDate) {
		this.id = id;
		this.proCode = proCode;
		this.proName = proName;
		this.proDesc = proDesc;
		this.proContact = proContact;
		this.proPhone = proPhone;
		this.proAddress = proAddress;
		this.proFax = proFax;
		this.creationDate = creationDate;
	}

	public String getProviderName() {
		return providerName;
	}

	public Provider() {
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProCode() {
		return proCode;
	}
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProDesc() {
		return proDesc;
	}
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
	public String getProContact() {
		return proContact;
	}
	public void setProContact(String proContact) {
		this.proContact = proContact;
	}
	public String getProPhone() {
		return proPhone;
	}
	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}
	public String getProAddress() {
		return proAddress;
	}
	public void setProAddress(String proAddress) {
		this.proAddress = proAddress;
	}
	public String getProFax() {
		return proFax;
	}
	public void setProFax(String proFax) {
		this.proFax = proFax;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "Provider{" +
				"id=" + id +
				", proCode='" + proCode + '\'' +
				", proName='" + proName + '\'' +
				", proDesc='" + proDesc + '\'' +
				", proContact='" + proContact + '\'' +
				", proPhone='" + proPhone + '\'' +
				", proAddress='" + proAddress + '\'' +
				", proFax='" + proFax + '\'' +
				", createdBy=" + createdBy +
				", creationDate=" + creationDate +
				", modifyBy=" + modifyBy +
				", modifyDate=" + modifyDate +
				'}';
	}
}
