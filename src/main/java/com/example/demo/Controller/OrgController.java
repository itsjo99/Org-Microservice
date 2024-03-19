package com.example.demo.Controller;

import com.example.demo.Exceptions.InvalidOrgRequest;
import com.example.demo.Model.Org;
import com.example.demo.Response.OrgResponse;
import com.example.demo.Service.OrgService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/org")
public class OrgController {

    OrgService orgService;

    public OrgController(OrgService orgService){
        this.orgService = orgService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerOrg(@RequestParam("orgName") String orgName, @RequestParam("city") String city){
        try{
            long id = orgService.registerOrg(orgName, city);
            return ResponseEntity.ok("Org registered successfully with id: "
                    + id);
        } catch(InvalidOrgRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @GetMapping("/all")
    public ResponseEntity<List<OrgResponse>> getAllOrgs(){
        List<Org> orgs = orgService.getAllOrgs();
        List<OrgResponse> response = new ArrayList<>();
        for(Org org : orgs){
            OrgResponse res = getOrgResponse(org);
            response.add(res);
        }
        return ResponseEntity.ok(response);
    }

    private OrgResponse getOrgResponse(Org org) {

        return new OrgResponse(org.getId(), org.getOrgName(), org.getCity());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<OrgResponse> editOrg(@PathVariable Long id, @RequestParam(required = false) String orgName,
                                       @RequestParam(required = false) String city){
        Org theOrg = orgService.editOrg(id, orgName, city);
        OrgResponse res = new OrgResponse(theOrg.getId(), theOrg.getOrgName(), theOrg.getCity());
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrg(@PathVariable Long id) {
        orgService.deleteOrg(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
