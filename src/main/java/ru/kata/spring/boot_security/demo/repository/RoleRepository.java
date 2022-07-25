package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Override
    <S extends Role> List<S> saveAll(Iterable<S> entities);

    @Override
    List<Role> findAll();

    Role findByName(String name);
}