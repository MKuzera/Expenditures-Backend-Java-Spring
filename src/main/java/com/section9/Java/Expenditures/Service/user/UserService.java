package com.section9.Java.Expenditures.Service.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void addRandom(){
        User user1 = new User(0,"Mati","xD","mati123","mati@gmail.com","password");
        User user2 = new User(1,"Mati2","xD2","mati1234","mati@gmail.com","password");
        User user3 = new User(2,"Mati3","xD3","mati1235","mati@gmail.com","password");
        User user4 = new User(3,"Mati4","xD4","mati1236","mati@gmail.com","password");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);

    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserByIdFromDataBase(Integer id){
        return userRepository.findUserById(id);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    // add security. this is not acceptable
    @Deprecated
    public User LoginUser(String login, String password){
        User userByLogin = userRepository.findUserByLogin(login);

        if(userByLogin == null){
            // throw 404 error back
        }
        else{
            if(userByLogin.getPassword().equals(password)){
                return userByLogin;
            }
        }
        // here return 400 error
        return null;
    }

}
