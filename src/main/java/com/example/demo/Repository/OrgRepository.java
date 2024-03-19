package com.example.demo.Repository;

import com.example.demo.Model.Org;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgRepository extends JpaRepository<Org,Long> {
 boolean existsByOrgName(String orgName);

 Org findByOrgName(String orgName);

}
