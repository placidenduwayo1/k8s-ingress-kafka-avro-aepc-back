package com.placide.k8skafkaavroaepccleanarchibsmicrosproject.infra.adapters.input.feignclients.proxies;

import com.placide.k8skafkaavroaepccleanarchibsmicrosproject.infra.adapters.input.feignclients.fallback.EmployeeServiceFallback;
import com.placide.k8skafkaavroaepccleanarchibsmicrosproject.infra.adapters.input.feignclients.models.EmployeeModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "k8s-ingress-kafka-avro-bs-ms-employee", url = "http://k8s-ingress-kafka-avro-bs-ms-employee:8783",
        path = "/bs-ms-employee",
        fallback = EmployeeServiceFallback.class)
@Qualifier(value = "employeeserviceproxy")
public interface EmployeeServiceProxy {
    @GetMapping("/employees/id/{employeeId}")
   EmployeeModel loadRemoteApiGetEmployee(@PathVariable(name = "employeeId") String employeeId);
    @GetMapping(value = "/employees/lastname/{lastname}")
    List<EmployeeModel> loadRemoteApiGetEmployeesByLastname(@PathVariable(name = "lastname") String lastname);
}
