package com.supermarket.dataobject;

public class employee_InfoDO {

    private String employeeId;
    private String employeeWork;
    private String employeeName;
    private String employeeSex;
    private Integer employeeAge;
    private String employeeIdcard;
    private String employeePhone;
    private String employeePassword;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeWork() {
        return employeeWork;
    }

    public void setEmployeeWork(String employeeWork) {
        this.employeeWork = employeeWork;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    public Integer getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeeIdcard() {
        return employeeIdcard;
    }

    public void setEmployeeIdcard(String employeeIdcard) {
        this.employeeIdcard = employeeIdcard;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public employee_InfoDO(String employeeId, String employeeWork, String employeeName, String employeeSex, Integer employeeAge, String employeeIdcard, String employeePhone, String employeePassword) {
        this.employeeId = employeeId;
        this.employeeWork = employeeWork;
        this.employeeName = employeeName;
        this.employeeSex = employeeSex;
        this.employeeAge = employeeAge;
        this.employeeIdcard = employeeIdcard;
        this.employeePhone = employeePhone;
        this.employeePassword = employeePassword;
    }
}