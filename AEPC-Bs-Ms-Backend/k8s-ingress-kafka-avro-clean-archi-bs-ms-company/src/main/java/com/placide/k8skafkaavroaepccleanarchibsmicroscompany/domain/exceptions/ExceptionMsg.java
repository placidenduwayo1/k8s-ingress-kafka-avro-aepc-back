package com.placide.k8skafkaavroaepccleanarchibsmicroscompany.domain.exceptions;


public enum ExceptionMsg {
    COMPANY_NOT_FOUND_EXCEPTION ("Company Not Found Exception"),
    COMPANY_FIELDS_EMPTY_EXCEPTION("Company One or more Fields Empty Exception"),
    COMPANY_ALREADY_EXISTS_EXCEPTION("Company Already Exists Exception"),
    COMPANY_TYPE_UNKNOWN_EXCEPTION("Company Type Unknown Exception"),
    REMOTE_ADDRESS_API_EXCEPTION("Remote Address Api Unreachable Exception"),
    COMPANY_ASSIGNED_PROJECT_EXCEPTION("Cannot Delete Company Already Assigned Remote Project(s) Exception: "),
    REMOTE_ADDRESS_ALREADY_HOLDS_COMPANY_EXCEPTION("Remote Address Already Holds Company Exception");
    private final String message;

    ExceptionMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
