package com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.infra.adatpters.input.feignclients.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyModel {
    private String companyId;
    private String name;
    private String agency;
    private String type;
    private String connectedDate;
}
