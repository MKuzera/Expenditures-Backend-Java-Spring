package com.section9.Java.Expenditures.Service.user;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserById();
}
