package com.placide.k8skafkaavroaepccleanarchibsmicroscompany.infra.adapters.output.repository;

import com.placide.k8skafkaavroaepccleanarchibsmicroscompany.infra.adapters.output.models.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyModel,String> {
    List<CompanyModel> findByNameAndAgencyAndType(String name, String agency, String type);
    List<CompanyModel> findByName(String companyName);
    List<CompanyModel> findByAgency(String agency);
    Optional<CompanyModel> findByAddressId(String addressId);
}
