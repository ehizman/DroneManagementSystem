package com.ehizman.drones.config;

import com.ehizman.drones.data.model.Privilege;
import com.ehizman.drones.data.model.Role;
import com.ehizman.drones.data.model.User;
import com.ehizman.drones.data.repository.PrivilegeRepository;
import com.ehizman.drones.data.repository.RoleRepository;
import com.ehizman.drones.data.repository.UserRepository;
import com.ehizman.drones.exceptions.DroneApplicationExceptionReason;
import com.ehizman.drones.exceptions.DronesApplicationException;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

import javax.transaction.Transactional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PrivilegeRepository privilegeRepository;
    private PasswordEncoder passwordEncoder;


    public SetupDataLoader(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PrivilegeRepository privilegeRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.privilegeRepository = privilegeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) return;
        Privilege registerNewDronePrivilege = createPrivilegeIfNotFound("register a new drone");
        Privilege loadADronePrivilege = createPrivilegeIfNotFound("load a drone");
        Privilege dispatchADronePrivilege = createPrivilegeIfNotFound("dispatch a drone");

        createRoleIfNotFound("ROLE_ADMIN", Set.of(loadADronePrivilege, registerNewDronePrivilege, dispatchADronePrivilege));
        createRoleIfNotFound("ROLE_USER", Set.of(dispatchADronePrivilege));


        Role adminRole = roleRepository.findByName("ROLE_ADMIN").orElseThrow(()-> new DronesApplicationException(DroneApplicationExceptionReason.ROLE_NOT_FOUND));
        User user = new User();
        user.setEmail("drone_admin@testemail.com");
        user.setFirstName("Test");
        user.setLastName("Admin");
        user.setPassword(passwordEncoder.encode("test"));
        user.setRoles(Set.of(adminRole));
        user.setEnabled(true);
        userRepository.save(user);

        alreadySetup = true;
    }

    @Transactional
    public Role createRoleIfNotFound(String name, Set<Privilege> privileges) {
        Role role = roleRepository.findByName(name).orElse(null);
        if (role == null){
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {
        Privilege privilege = privilegeRepository.findByName(name).orElse(null);
        if (privilege == null){
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }
}
