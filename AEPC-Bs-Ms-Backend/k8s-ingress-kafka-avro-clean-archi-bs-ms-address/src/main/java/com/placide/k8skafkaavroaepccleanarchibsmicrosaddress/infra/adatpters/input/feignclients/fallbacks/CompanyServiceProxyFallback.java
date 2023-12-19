package com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.infra.adatpters.input.feignclients.fallbacks;

import com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.infra.adatpters.input.feignclients.models.CompanyModel;
import com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.infra.adatpters.input.feignclients.proxy.CompanyServiceProxy;
import org.springframework.stereotype.Component;
@Component
public class CompanyServiceProxyFallback implements CompanyServiceProxy {
    @Override
    public CompanyModel getRemoteCompanyAtAddress(String addressId) {
        return null;
    }
}
