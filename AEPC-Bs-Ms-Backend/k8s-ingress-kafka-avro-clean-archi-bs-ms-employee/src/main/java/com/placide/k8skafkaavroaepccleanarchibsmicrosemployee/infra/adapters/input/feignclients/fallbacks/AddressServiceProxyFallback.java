package com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.infra.adapters.input.feignclients.fallbacks;

import com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.infra.adapters.input.feignclients.models.AddressModel;
import com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.infra.adapters.input.feignclients.proxies.AddressServiceProxy;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.domain.exceptions
        .ExceptionsMsg.REMOTE_ADDRESS_API_EXCEPTION;
@Component
public class AddressServiceProxyFallback implements AddressServiceProxy {
    @Override
    public AddressModel loadRemoteAddressById(String addressId) {
       return buildFakeModel();
    }
    @Override
    public List<AddressModel> loadAllRemoteAddresses() {
        return List.of(buildFakeModel());
    }

    @Override
    public List<AddressModel> loadRemoteAddressesByCity(String city) {
        return List.of(buildFakeModel());
    }
    private AddressModel buildFakeModel(){
        return AddressModel.builder()
                .addressId(REMOTE_ADDRESS_API_EXCEPTION.getMessage())
                .num(0)
                .street(REMOTE_ADDRESS_API_EXCEPTION.getMessage())
                .poBox(0)
                .city(REMOTE_ADDRESS_API_EXCEPTION.getMessage())
                .country(REMOTE_ADDRESS_API_EXCEPTION.getMessage())
                .build();
    }
}
