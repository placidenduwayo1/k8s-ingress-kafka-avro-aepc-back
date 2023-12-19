package com.placide.k8skafkaavroaepccleanarchibsmicroscompany.infra.adapters.input.controller;

import com.placide.k8skafkaavroaepccleanarchibsmicroscompany.domain.beans.company.Company;
import com.placide.k8skafkaavroaepccleanarchibsmicroscompany.domain.exceptions.*;
import com.placide.k8skafkaavroaepccleanarchibsmicroscompany.domain.ports.input.InputCompanyService;
import com.placide.k8skafkaavroaepccleanarchibsmicroscompany.infra.adapters.output.models.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/bs-ms-company")
public class CompanyController {
    private final InputCompanyService companyService;
    @GetMapping(value = "")
    public ResponseEntity<Object> getWelcome(){
        return new ResponseEntity<>("Welcome to business microservice company that managing companies", HttpStatus.OK);
    }

    @PostMapping(value = "/companies")
    public List<String> produceConsumeAndSaveCompany(@RequestBody CompanyDto dto) throws
            CompanyEmptyFieldsException, CompanyAlreadyExistsException, CompanyTypeInvalidException, RemoteApiAddressNotLoadedException,
            RemoteAddressAlreadyHoldsCompanyException {

        Company consumed = companyService.produceKafkaEventCompanyCreate(dto);
        Company saved = companyService.createCompany(consumed);
       return List.of("produced & consumed:"+consumed,"saved:"+saved);
    }
    @GetMapping(value = "/companies")
    public List<Company> loadAllCompanies(){
       return companyService.loadAllCompanies();
    }
    @GetMapping(value = "/companies/id/{id}")
    public Optional<Company> loadCompany(@PathVariable(name = "id") String id) throws CompanyNotFoundException, RemoteApiAddressNotLoadedException {
        return companyService.getCompanyById(id);
    }
    @PutMapping(value = "/companies/id/{id}")
    public List<String> updateCompany(@RequestBody CompanyDto dto, @PathVariable(name = "id") String id) throws
            CompanyEmptyFieldsException, CompanyTypeInvalidException, CompanyNotFoundException, RemoteApiAddressNotLoadedException, RemoteAddressAlreadyHoldsCompanyException {
        Company consumed = companyService.produceKafkaEventCompanyEdit(dto,id);
        Company saved = companyService.editCompany(consumed);
        return List.of("produced & consumed:"+consumed,"saved:"+saved);
    }
    @DeleteMapping(value = "/companies/id/{id}")
    public ResponseEntity<Object> deleteCompany(@PathVariable(name = "id") String id) throws CompanyNotFoundException,
            RemoteApiAddressNotLoadedException, CompanyAlreadyAssignedRemoteProjectsException {
        Company consumed = companyService.produceKafkaEventCompanyDelete(id);
        companyService.deleteCompany(consumed.getCompanyId());
        return new ResponseEntity<>(String.format("<%s> to delete is sent to topic, %n <%s> is deleted from db",
                consumed, id), HttpStatus.OK);
    }
    @GetMapping(value = "/companies/name/{companyName}")
    public List<Company> getCompaniesByName(@PathVariable(name = "companyName") String companyName){
        return companyService.getCompaniesByName(companyName);
    }
    @GetMapping(value = "/companies/agency/{agency}")
    public List<Company> getCompanyByAgency(@PathVariable(name = "agency") String agency){
        return companyService.getCompanyByAgency(agency);
    }
    @GetMapping(value = "/companies/addresses/id/{addressId}")
    public Company getCompanyOfGivenAddressId(@PathVariable(name = "addressId") String addressId) throws RemoteApiAddressNotLoadedException,
            CompanyNotFoundException {
        return companyService.getCompanyOfGivenAddressId(addressId);
    }
    @GetMapping(value = "/companies/addresses/city/{city}")
    public List<Company> getCompaniesOfGivenAddressCity(@PathVariable(name = "city") String city) throws RemoteApiAddressNotLoadedException, CompanyNotFoundException {
        return companyService.getCompaniesOfGivenAddressCity(city);
    }
}
