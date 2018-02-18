package com.example.easynotes.repository;

import com.example.easynotes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by amer on 2/18/18.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
