package com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.infra.adapters.input.controller;

import com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.domain.beans.address.Address;
import com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.domain.beans.employee.Employee;
import com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.domain.exceptions.*;
import com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.domain.ports.input.InputEmployeeService;
import com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.domain.ports.input.RemoteInputAddressService;
import com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.infra.adapters.output.models.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/bs-ms-employee")
public class EmployeeController {
    private final InputEmployeeService inputEmployeeService;
    private final RemoteInputAddressService remoteInputAddressService;
    @GetMapping(value = "")
    public ResponseEntity<Object> getWelcome(){
        return new ResponseEntity<>("Welcome to business microservice employee that managing employees", HttpStatus.OK);
    }
    @PostMapping(value = "/employees")
    public List<String> produceConsumeAndSaveEmployee(@RequestBody EmployeeDto employeeDto) throws
            EmployeeTypeInvalidException, EmployeeEmptyFieldsException, EmployeeStateInvalidException,
            RemoteApiAddressNotLoadedException, EmployeeAlreadyExistsException {

       Employee consumed = inputEmployeeService.produceKafkaEventEmployeeCreate(employeeDto);
       Employee saved = inputEmployeeService.createEmployee(consumed);
        return List.of("produced consumed:"+consumed,"saved:"+saved);
    }
    @GetMapping(value = "/employees/addresses/id/{addressId}")
    public Address getRemoteAddress(@PathVariable(name = "addressId") String addressId) throws
            RemoteApiAddressNotLoadedException{
        return remoteInputAddressService.getRemoteAddressById(addressId);
    }
    @GetMapping(value = "/employees/addresses")
    public List<Address> getRemoteAddresses(){
       return remoteInputAddressService.loadRemoteAllAddresses();
    }
    @GetMapping(value = "/employees/addresses/{addressId}")
    public List<Employee> loadEmployeesOnGivenAddress(@PathVariable(name = "addressId") String addressId) throws
            RemoteApiAddressNotLoadedException {
        return inputEmployeeService.loadEmployeesByRemoteAddress(addressId);
    }
    @GetMapping(value = "/employees")
    public List<Employee> loadAllEmployees(){
        return inputEmployeeService.loadAllEmployees();
    }
    @GetMapping(value = "/employees/id/{id}")
    public Employee getEmployee(@PathVariable(name = "id") String id) throws EmployeeNotFoundException, RemoteApiAddressNotLoadedException {
        return inputEmployeeService.getEmployeeById(id).orElseThrow(EmployeeNotFoundException::new);
    }
    @DeleteMapping(value = "/employees/id/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") String id) throws EmployeeNotFoundException, RemoteApiAddressNotLoadedException,
            EmployeeAlreadyAssignedProjectException {
        Employee consumed = inputEmployeeService.produceKafkaEventEmployeeDelete(id);
        inputEmployeeService.deleteEmployee(consumed.getEmployeeId());
        return new ResponseEntity<>(String
                .format("<%s> to delete is sent to topic, %n <%s> is deleted from db", consumed, id),
                HttpStatus.OK);
    }
    @PutMapping(value = "/employees/id/{id}")
    public List<String> update(@PathVariable(name = "id") String id, @RequestBody EmployeeDto dto) throws EmployeeTypeInvalidException,
            EmployeeEmptyFieldsException, EmployeeStateInvalidException, RemoteApiAddressNotLoadedException, EmployeeNotFoundException {
        Employee consumed = inputEmployeeService.produceKafkaEventEmployeeEdit(dto,id);
        Employee saved = inputEmployeeService.editEmployee(consumed);
        return List.of("produced consumed:"+consumed,"saved:"+saved);
    }
    @GetMapping(value = "/employees/lastname/{employeeLastname}")
    public List<Employee> getEmployeeByLastname(@PathVariable(name = "employeeLastname") String employeeLastname){
        return inputEmployeeService.getEmployeesByLastname(employeeLastname);
    }
    @GetMapping(value = "/employees/addresses/city/{city}")
    public List<Employee> getEmployeesByRemoteAddressCity(@PathVariable(name = "city") String city) throws RemoteApiAddressNotLoadedException {
        return inputEmployeeService.loadEmployeesByRemoteAddressCity(city);
    }
}
