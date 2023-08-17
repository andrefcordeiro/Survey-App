package com.project.surveyapp.entities.enums;

public enum UserRole {

    COORDINATOR(0),
    RESPONDENT(1);

    private int code;

    private UserRole(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static UserRole valueOf(int code) {
        for (UserRole value : UserRole.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid UserRole code");
    }
}
