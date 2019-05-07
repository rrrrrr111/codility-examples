package ru.roman.jcl.security;

import java.security.Permission;

/**
 * JCL API Examples
 */
class SecurityManagerExample {

    public static void forbidExit() {
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {            // prevent System.exit() call
                    throw new SecurityException();
                }
            }
        });
    }
}
