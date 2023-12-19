package com.placide.k8skafkaavroaepccleanarchibsmicrosproject.infra.adapters.input.feignclients.models;

import lombok.Builder;
import lombok.Data;

@Builder @Data
public class EmployeeModel {
    private String employeeId;
    private String firstname;
    private String lastname;
    private String email;
    private String hireDate;
    private String state;
    private String type;
}
