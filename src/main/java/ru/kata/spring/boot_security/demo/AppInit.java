package ru.kata.spring.boot_security.demo;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class AppInit {

    private final UserService userService;
    private final RoleService roleService;

    public AppInit(UserService userRepository, RoleService roleRepository) {
        this.userService = userRepository;
        this.roleService = roleRepository;
    }

    @PostConstruct
    public void createUsers() {
        Role user = new Role("ROLE_USER");
        Role admin = new Role("ROLE_ADMIN");

        roleService.save(user);
        roleService.save(admin);

        User user1 = new User("adminuser@mail.ru", "0000");//"$2a$12$54rDWKSismZ9uGff8bWwvetMn/YqhjzHl0P3D7JxY8GSyXeI2zM9e"
        User user2 = new User("admin@mail.ru", "0000");//"$2a$12$54rDWKSismZ9uGff8bWwvetMn/YqhjzHl0P3D7JxY8GSyXeI2zM9e"
        User user3 = new User("user@mail.ru", "0000");//"$2a$12$54rDWKSismZ9uGff8bWwvetMn/YqhjzHl0P3D7JxY8GSyXeI2zM9e"

        user1.setRole(roleService.findByName("ROLE_ADMIN"));
        user1.setRole(roleService.findByName("ROLE_USER"));
        user2.setRole(roleService.findByName("ROLE_ADMIN"));
        user3.setRole(roleService.findByName("ROLE_USER"));

        user3.setFirstName("Ivan");
        user3.setLastName("Ivanov");
        user3.setAge(33);


        user1.setFirstName("Artur");
        user1.setLastName("Arturov");
        user1.setAge(22);


        user2.setFirstName("Katya");
        user2.setLastName("Kateva");
        user2.setAge(11);


        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);

    }
}
