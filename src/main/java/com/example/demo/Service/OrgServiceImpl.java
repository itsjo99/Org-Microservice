package com.example.demo.Service;

import com.example.demo.Exceptions.OrgAlreadyExistsException;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.Model.Org;
import com.example.demo.Repository.OrgRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrgServiceImpl implements OrgService{

    OrgRepository orgRepository;

    public OrgServiceImpl(OrgRepository orgRepository){
        this.orgRepository = orgRepository;
    }
    @Override
    public long registerOrg(String orgName, String city) throws OrgAlreadyExistsException {
        Org org = new Org();
        if(orgRepository.existsByOrgName(orgName)){
            throw new OrgAlreadyExistsException("already exists");
        }
        org.setOrgName(orgName);
        org.setCity(city);
        orgRepository.save(org);
        return org.getId();
    }

    @Override
    public List<Org> getAllOrgs() {
        return orgRepository.findAll();

    }

    @Override
    public Org editOrg(Long id, String orgName, String city) {
        Org org = orgRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found"));
        if(orgName != null) {
            org.setOrgName(orgName);
        }
        if(city != null){
            org.setCity(city);
        }
        return orgRepository.save(org);
    }

    @Override
    public Org findOrgByName(String orgName) {
        return orgRepository.findByOrgName(orgName);

    }

    @Override
    public void deleteOrg(Long id) {
        Optional<Org> theOrg = orgRepository.findById(id);
        if(theOrg.isPresent()){
            orgRepository.deleteById(id);
        }
    }
}
