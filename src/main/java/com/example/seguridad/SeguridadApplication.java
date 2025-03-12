package com.example.seguridad;

import com.example.seguridad.Persistence.entity.PermissionEntity;
import com.example.seguridad.Persistence.entity.RoleEmun;
import com.example.seguridad.Persistence.entity.RoleEntity;
import com.example.seguridad.Persistence.entity.UserEntity;
import com.example.seguridad.Persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SeguridadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeguridadApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {

			/* Creación de permisos */
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("REFACTOR")
					.build();



			/* Creación de roles */
			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEmun.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEmun.USER)
					.permissionList(Set.of(createPermission, readPermission))
					.build();

			RoleEntity roleInvited = RoleEntity.builder()
					.roleEnum(RoleEmun.INVITED)
					.permissionList(Set.of(readPermission))
					.build();

			RoleEntity roleDeveloper = RoleEntity.builder()
					.roleEnum(RoleEmun.DEVELOPER)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
					.build();


			/* Crear Usuarios */
			UserEntity userSantiago = UserEntity.builder()
					.username("santiago")
					.password("1234")
					.isEnabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity userNicolas = UserEntity.builder()
					.username("nicolas")
					.password("1234")
					.isEnabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			UserEntity userMiranda= UserEntity.builder()
					.username("miranda")
					.password("1234")
					.isEnabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNoExpired(true)
					.roles(Set.of(roleInvited))
					.build();

			UserEntity userMartinetti = UserEntity.builder()
					.username("martinetti")
					.password("1234")
					.isEnabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNoExpired(true)
					.roles(Set.of(roleDeveloper))
					.build();

			userRepository.saveAll(List.of(userSantiago, userMiranda, userNicolas, userMartinetti));
		};
	}
}
