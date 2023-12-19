package com.placide.k8skafkaavroaepccleanarchibsmicroscompany.infra.adapters.output.models;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class CompanyDto {
    private String name;
    private String agency;
    private String type;
    private String addressId;
}
