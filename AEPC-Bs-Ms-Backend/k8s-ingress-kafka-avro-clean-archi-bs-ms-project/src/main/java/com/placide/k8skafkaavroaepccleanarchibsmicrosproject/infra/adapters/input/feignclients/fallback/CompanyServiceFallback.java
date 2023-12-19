package com.placide.k8skafkaavroaepccleanarchibsmicrosproject.infra.adapters.input.feignclients.fallback;

import com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.exceptions.ExceptionMsg;
import com.placide.k8skafkaavroaepccleanarchibsmicrosproject.infra.adapters.input.feignclients.models.CompanyModel;
import com.placide.k8skafkaavroaepccleanarchibsmicrosproject.infra.adapters.input.feignclients.proxies.CompanyServiceProxy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyServiceFallback implements CompanyServiceProxy {
    @Override
    public CompanyModel loadRemoteCompanyApiById(String companyId) {
        return buildFakeModel();
    }

    @Override
    public List<CompanyModel> loadRemoteCompanyApiByName(String companyName) {
        return List.of(buildFakeModel());
    }

    @Override
    public List<CompanyModel> loadRemoteCompanyApiByAgency(String companyAgency) {
        return List.of(buildFakeModel());
    }
    private CompanyModel buildFakeModel(){
       return CompanyModel.builder()
                .companyId(ExceptionMsg.REMOTE_COMPANY_API_EXCEPTION.getMessage())
                .name(ExceptionMsg.REMOTE_COMPANY_API_EXCEPTION.getMessage())
                .agency(ExceptionMsg.REMOTE_COMPANY_API_EXCEPTION.getMessage())
                .type(ExceptionMsg.REMOTE_COMPANY_API_EXCEPTION.getMessage())
                .connectedDate(ExceptionMsg.REMOTE_COMPANY_API_EXCEPTION.getMessage())
                .build();
    }
}
