package com.placide.k8skafkaavroaepccleanarchibsmicrosproject.infra.adapters.input.feignclients.models;

import lombok.Builder;
import lombok.Data;

@Builder @Data
public class CompanyModel {
    private String companyId;
    private String name;
    private String agency;
    private String type;
    private String connectedDate;
}
