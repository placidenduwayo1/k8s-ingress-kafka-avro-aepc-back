package com.placide.k8skafkaavroaepccleanarchibsmicrosemployee.domain.exceptions;

public enum ExceptionsMsg {
    EMPLOYEE_ALREADY_EXISTS_EXCEPTION("Employee Already Exists Exception"),
    EMPLOYEE_NOT_FOUND_EXCEPTION("Employee Not Found Exception"),
    EMPLOYEE_FIELDS_EMPTY_EXCEPTION("Employee One or More Fields Empty Exception"),
    EMPLOYEE_UNKNOWN_STATE_EXCEPTION("Employee State Unknown Exception"),
    EMPLOYEE_UNKNOWN_TYPE_EXCEPTION("Employee Type Unknown Exception"),
    REMOTE_ADDRESS_API_EXCEPTION("Remote Address Api Unreachable Exception"),
    EMPLOYEE_ASSIGNED_REMOTE_PROJECT_API_EXCEPTION("Cannot Remove Employee Assigned Project Exception: ");
    private final String message;
    ExceptionsMsg(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
