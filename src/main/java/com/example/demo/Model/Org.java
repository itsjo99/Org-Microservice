package com.example.demo.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Org {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String orgName;
    private String city;
    @OneToMany(mappedBy="org", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> users;

    public Org() {
    }

    public Org(long id, String orgName, String city, List<User> users) {
        this.id = id;
        this.orgName = orgName;
        this.city = city;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
