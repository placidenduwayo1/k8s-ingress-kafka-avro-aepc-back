package com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.infra.adapters.input.feignclients.proxies;

import com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.domain.exceptions.RemoteApiAddressNotLoadedException;
import com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.infra.adapters.input.feignclients.models.AddressModel;
import com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.infra.adapters.input.feignclients.fallbacks.AddressServiceProxyFallback;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "k8s-ingress-kafka-avro-bs-ms-address", url = "http://k8s-ingress-kafka-avro-bs-ms-address:8781",
        path = "/bs-ms-address", fallback = AddressServiceProxyFallback.class)
@Qualifier(value = "addressserviceproxy")
public interface AddressServiceProxy {
    @GetMapping(value = "/addresses/id/{addressId}")
   AddressModel loadRemoteAddressById(@PathVariable String addressId) throws RemoteApiAddressNotLoadedException;
    @GetMapping(value = "/addresses")
    List<AddressModel> loadAllRemoteAddresses();
    @GetMapping(value = "/addresses/city/{city}")
    List<AddressModel> loadRemoteAddressesByCity(@PathVariable(name = "city") String city);
}