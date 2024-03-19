package com.example.demo.Response;

public class OrgResponse {

    private long orgId;
    private String orgName;
    private String city;

    public OrgResponse(long orgId, String orgName, String city) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.city = city;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
