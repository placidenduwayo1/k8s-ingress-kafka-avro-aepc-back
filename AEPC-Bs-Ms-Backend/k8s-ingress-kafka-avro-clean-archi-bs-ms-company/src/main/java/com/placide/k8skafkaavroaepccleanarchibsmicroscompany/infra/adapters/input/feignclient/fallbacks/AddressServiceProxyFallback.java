package com.placide.k8skafkaavroaepccleanarchibsmicroscompany.infra.adapters.input.feignclient.fallbacks;

import com.placide.k8skafkaavroaepccleanarchibsmicroscompany.infra.adapters.input.feignclient.models.AddressModel;
import com.placide.k8skafkaavroaepccleanarchibsmicroscompany.infra.adapters.input.feignclient.proxies.AddressServiceProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.placide.k8skafkaavroaepccleanarchibsmicroscompany.domain.exceptions.ExceptionMsg;

import java.util.List;

@Component
@Slf4j
public class AddressServiceProxyFallback implements AddressServiceProxy {
    @Override
    public AddressModel loadRemoteApiGetAddressById(String addressId) {
       AddressModel resilience = buildFakeAddress();
       log.info("[Fallback] resilience management {}",resilience);
       return resilience;
    }

    @Override
    public List<AddressModel> loadRemoteApiAddressesByCity(String city) {
        return List.of(buildFakeAddress());
    }

    private AddressModel buildFakeAddress(){
        return AddressModel.builder()
                .addressId(ExceptionMsg.REMOTE_ADDRESS_API_EXCEPTION.getMessage())
                .num(0)
                .street(ExceptionMsg.REMOTE_ADDRESS_API_EXCEPTION.getMessage())
                .poBox(0)
                .city(ExceptionMsg.REMOTE_ADDRESS_API_EXCEPTION.getMessage())
                .country(ExceptionMsg.REMOTE_ADDRESS_API_EXCEPTION.getMessage())
                .build();
    }
}
