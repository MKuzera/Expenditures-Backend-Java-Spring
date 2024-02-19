package com.section9.Java.Expenditures.Service.user;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.JpaRepository;

@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer integer);
    User findUserByLogin(String login);

}
