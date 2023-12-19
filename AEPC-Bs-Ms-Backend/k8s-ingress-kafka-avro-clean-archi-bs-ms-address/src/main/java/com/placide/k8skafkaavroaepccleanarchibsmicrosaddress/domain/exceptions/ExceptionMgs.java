package com.placide.k8skafkaavroaepccleanarchibsmicrosaddress.domain.exceptions;

public enum ExceptionMgs {
    ADDRESS_ALREADY_EXISTS_EXCEPTION("Address Already Exists Exception"),
    ADDRESS_FIELDS_INVALID_EXCEPTION("Address Fields Invalid Exception"),
    ADDRESS_NOT_FOUND_EXCEPTION("Address Not Found Exception"),
    ADDRESS_CITY_NOT_EXCEPTION("Address City Not Found Exception"),
    ADDRESS_ASSIGNED_COMPANY_EXCEPTION("Address Already Assigned Company Exception: "),
    ADDRESS_ASSIGNED_EMPLOYEE_EXCEPTION("Address Already Assigned Employee Exception: ");
    private final String msg;
    ExceptionMgs(String message) {
        this.msg = message;
    }
    public String getMsg() {
        return msg;
    }
}
