package com.springboot.data.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.data.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

}
