package com.pilaka.springjwt.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pilaka.springjwt.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long>   {

}
