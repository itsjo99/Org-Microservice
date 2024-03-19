package com.example.demo.Service;


import com.example.demo.Exceptions.OrgAlreadyExistsException;
import com.example.demo.Model.Org;

import java.math.BigDecimal;
import java.util.List;

public interface OrgService {

    long registerOrg(String orgName, String city) throws OrgAlreadyExistsException;

    List<Org> getAllOrgs();

    Org editOrg(Long id, String orgName, String city);

    Org findOrgByName(String orgName);

    void deleteOrg(Long id);
}
