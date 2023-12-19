package com.placide.k8skafkaavroaepccleanarchibsmicroscompany.infra.adapters.input.feignclient.models;

import lombok.*;

@Builder @Data
public class AddressModel {
    private String addressId;
    private int num;
    private String street;
    private int poBox;
    private String city;
    private String country;
}
