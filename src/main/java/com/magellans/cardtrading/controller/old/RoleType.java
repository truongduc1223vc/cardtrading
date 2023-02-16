package com.magellans.cardtrading.controller.old;


public enum RoleType implements Enumerable {
    rm("rm"), customer("customer");

    private final String value;

    RoleType(String value) {
        this.value = value;
    }

    public static RoleType fromString(String value) {
        for (RoleType val : values()) {
            if (val.value.equalsIgnoreCase(value))
                return val;
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int value() {
        return 0;
    }
}