package com.ehizman.drones.data.model.enums;

import com.google.common.collect.Sets;
import org.hibernate.query.criteria.internal.SelectionImplementor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.ehizman.drones.data.model.enums.Permission.PACKAGE_READ;
import static com.ehizman.drones.data.model.enums.Permission.PACKAGE_WRITE;

public enum Role {
    USER(Sets.newHashSet(PACKAGE_READ, PACKAGE_WRITE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
        Set<SimpleGrantedAuthority> permissions = getPermissions()
                .stream().map(permission ->  new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
