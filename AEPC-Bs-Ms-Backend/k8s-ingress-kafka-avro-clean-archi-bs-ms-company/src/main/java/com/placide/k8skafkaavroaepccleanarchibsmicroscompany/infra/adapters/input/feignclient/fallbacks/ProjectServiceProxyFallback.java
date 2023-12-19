package com.placide.k8skafkaavroaepccleanarchibsmicroscompany.infra.adapters.input.feignclient.fallbacks;

import com.placide.k8skafkaavroaepccleanarchibsmicroscompany.infra.adapters.input.feignclient.models.ProjectModel;
import com.placide.k8skafkaavroaepccleanarchibsmicroscompany.infra.adapters.input.feignclient.proxies.ProjectServiceProxy;
import java.util.Collections;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectServiceProxyFallback implements ProjectServiceProxy {
    @Override
    public List<ProjectModel> loadRemoteProjectsOfCompany(String companyId) {
        return Collections.emptyList();
    }
}
