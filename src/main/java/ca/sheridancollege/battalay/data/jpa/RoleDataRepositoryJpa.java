package ca.sheridancollege.battalay.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDataRepositoryJpa extends JpaRepository<RoleEntity, Integer> {

    RoleEntity findRoleEntityByRoleNameIs(String roleName);
}
