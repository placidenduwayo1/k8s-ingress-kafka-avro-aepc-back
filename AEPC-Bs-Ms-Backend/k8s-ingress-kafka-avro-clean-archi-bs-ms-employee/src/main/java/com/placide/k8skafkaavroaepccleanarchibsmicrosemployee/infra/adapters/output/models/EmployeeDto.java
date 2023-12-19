package com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.infra.adapters.output.models;

import lombok.Builder;
import lombok.Data;
@Builder @Data
public class EmployeeDto {
    private String firstname;
    private String lastname;
    private String state;
    private String type;
    private String addressId;
}
