package com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.infra.adapters.input.feignclients.fallbacks;

import com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.infra.adapters.input.feignclients.models.ProjectModel;
import com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.infra.adapters.input.feignclients.proxies.ProjectServiceProxy;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ProjectServiceProxyFallback implements ProjectServiceProxy {
    @Override
    public List<ProjectModel> getRemoteProjectsAssignedToEmployee(String employeeId) {
        return Collections.emptyList();
    }
}
