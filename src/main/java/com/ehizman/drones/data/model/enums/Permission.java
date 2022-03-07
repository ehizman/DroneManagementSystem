package com.ehizman.drones.data.model.enums;

public enum Permission {
    PACKAGE_READ("package:read"),
    PACKAGE_WRITE("package:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}
