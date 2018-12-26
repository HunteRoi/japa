package com.japa.Japa.dataAccess.repository;

import com.japa.Japa.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String userName);
}
