package org.example.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: WangTao
 * @Date: 2023-02-01 11:44
 * @Version: 1.0
 * @Desc:
 */
public class Company implements Serializable {
    private static final long serialVersionUID = -1642470704910746036L;

    /**
     * id
     */
    private String id;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 法人代表
     */
    private String representative;

    /**
     * 公司电话
     */
    private String phone;

    /**
     * 公司地址
     */
    private String address;

    /**
     * 营业执照(图片地址)
     */
    private String licenseId;

    /**
     * 有效日期
     */
    private Date expirationDate;

    /**
     * 注册资金
     */
    private Double registeredCapital;

    /**
     * 公司规模
     */
    private String companySize;

    /**
     * 所属行业
     */
    private String industry;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 状态
     */
    private Integer state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public Double getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(Double registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Company{" +
         "id='" + id + '\'' +
         ", name='" + name + '\'' +
         ", representative='" + representative + '\'' +
         ", phone='" + phone + '\'' +
         ", address='" + address + '\'' +
         ", licenseId='" + licenseId + '\'' +
         ", expirationDate=" + expirationDate +
         ", registeredCapital=" + registeredCapital +
         ", companySize='" + companySize + '\'' +
         ", industry='" + industry + '\'' +
         ", remarks='" + remarks + '\'' +
         ", state=" + state +
         '}';
    }
}