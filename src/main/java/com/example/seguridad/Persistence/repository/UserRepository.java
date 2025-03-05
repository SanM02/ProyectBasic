package com.example.seguridad.Persistence.repository;

import com.example.seguridad.Persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByUsername(String username);

    // Unos de los metodos que se pueden usar para traer los usuarios de la base de datos
    // @Query("SELECT u FROM UserEntity u WHERE u.username = ?")
    // Optional<UserEntity> findUser(String username);
}
