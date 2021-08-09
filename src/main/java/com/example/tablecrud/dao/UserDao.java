package com.example.tablecrud.dao;

import com.example.tablecrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// dao가 repository.
@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
