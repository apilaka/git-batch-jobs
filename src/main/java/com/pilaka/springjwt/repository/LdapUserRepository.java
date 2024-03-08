package com.pilaka.springjwt.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pilaka.springjwt.entity.LdapUser;

@Repository
public interface LdapUserRepository extends JpaRepository<LdapUser,Long>   {
	
	Optional<LdapUser> findByEmail(String email);

}
