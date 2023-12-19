package com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.infra.adatpters.input.feignclients.proxy;

import com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.infra.adatpters.input.feignclients.fallbacks.EmployeeServiceProxyFallback;
import com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.infra.adatpters.input.feignclients.models.EmployeeModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "k8s-ingress-kafka-avro-bs-ms-employee", url = "http://k8s-ingress-kafka-avro-bs-ms-employee:8783",
path = "/bs-ms-employee", fallback = EmployeeServiceProxyFallback.class)
@Qualifier(value = "employeeserviceproxy")
public interface EmployeeServiceProxy {
    @GetMapping(value = "/employees/addresses/{addressId}")
    List<EmployeeModel> getRemoteEmployeesLivingAtAddress(@PathVariable(name = "addressId") String addressId);
}
