package com.example.demo.Response;

public class UserResponse {

    private long userId;
    private String userName;
    private String phone;
    private String orgName;

    public UserResponse() {
    }

    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId){
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public UserResponse(long userId, String userName, String phone, String orgName){
        this.userId = userId;
        this.userName = userName;
        this.phone = phone;
        this.orgName = orgName;
    }
}
