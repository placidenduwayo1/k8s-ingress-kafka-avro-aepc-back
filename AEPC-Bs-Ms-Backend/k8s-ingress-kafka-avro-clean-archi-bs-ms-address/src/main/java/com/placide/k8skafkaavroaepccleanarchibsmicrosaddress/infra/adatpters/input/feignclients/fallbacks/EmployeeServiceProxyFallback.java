package com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.infra.adatpters.input.feignclients.fallbacks;

import com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.infra.adatpters.input.feignclients.models.EmployeeModel;
import com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.infra.adatpters.input.feignclients.proxies.EmployeeServiceProxy;
import java.util.Collections;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceProxyFallback implements EmployeeServiceProxy {
    @Override
    public List<EmployeeModel> getRemoteEmployeesLivingAtAddress(String addressId) {
        return Collections.emptyList();
    }
}
