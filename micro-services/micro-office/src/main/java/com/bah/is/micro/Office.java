package com.bah.is.micro;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Office {
    @Id
    private String code;
    private String name;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String phone;
    private String fax;  
    private String city;
    private String stateName;
    private String stateCode;
    private String countryName;
    private String countryCode;
    private String addressLine1;
    private String addressLine2;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getLongitude() {
        return longitude;
    }
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
    public BigDecimal getLatitude() {
        return latitude;
    }
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStateName() {
        return stateName;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public String getStateCode() {
        return stateCode;
    }
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getAddressLine1() {
        return addressLine1;
    }
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    public String getAddressLine2() {
        return addressLine2;
    }
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
 
}
