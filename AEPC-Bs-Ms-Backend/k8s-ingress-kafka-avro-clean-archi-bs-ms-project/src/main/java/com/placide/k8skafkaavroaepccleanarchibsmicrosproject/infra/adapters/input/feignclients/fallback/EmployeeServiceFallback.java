package com.placide.k8skafkaavroaepccleanarchibsmicrosproject.infra.adapters.input.feignclients.fallback;

import com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.exceptions.ExceptionMsg;
import com.placide.k8skafkaavroaepccleanarchibsmicrosproject.infra.adapters.input.feignclients.models.EmployeeModel;
import com.placide.k8skafkaavroaepccleanarchibsmicrosproject.infra.adapters.input.feignclients.proxies.EmployeeServiceProxy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceFallback implements EmployeeServiceProxy {
    @Override
    public EmployeeModel loadRemoteApiGetEmployee(String employeeId) {
        return buildFakeModel();
    }

    @Override
    public List<EmployeeModel> loadRemoteApiGetEmployeesByLastname(String lastname) {
        return List.of(buildFakeModel());
    }

    private EmployeeModel buildFakeModel(){
        return EmployeeModel.builder()
                .employeeId(ExceptionMsg.REMOTE_EMPLOYEE_API_EXCEPTION.getMessage())
                .firstname(ExceptionMsg.REMOTE_EMPLOYEE_API_EXCEPTION.getMessage())
                .lastname(ExceptionMsg.REMOTE_EMPLOYEE_API_EXCEPTION.getMessage())
                .email(ExceptionMsg.REMOTE_EMPLOYEE_API_EXCEPTION.getMessage())
                .hireDate(ExceptionMsg.REMOTE_EMPLOYEE_API_EXCEPTION.getMessage())
                .state(ExceptionMsg.REMOTE_EMPLOYEE_API_EXCEPTION.getMessage())
                .type(ExceptionMsg.REMOTE_EMPLOYEE_API_EXCEPTION.getMessage())
                .build();
    }
}
