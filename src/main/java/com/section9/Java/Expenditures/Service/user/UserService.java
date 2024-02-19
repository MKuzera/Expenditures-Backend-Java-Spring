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
        // adds random data into database ->
        // used because I didn't want to connect to DB from my local machine using xampp.
        User user1 = new User(0,"-","-","mati123","mati@gmail.com","password");
        User user2 = new User(1,"Mati2","xD2","mati1234","mati@gmail.com","password");
        User user3 = new User(2,"Mati3","xD3","mati1235","mati@gmail.com","password");
        User user4 = new User(3,"Mati4","xD4","mati1236","mati@gmail.com","password");
        User user5 = new User(4,"Mateusz","Kuzera","qzera","q@q.com","pass");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
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


    @Deprecated  // add security. this is not acceptable
    public User LoginUser(String login, String password){
        User userByLogin = userRepository.findUserByLogin(login);

        if(userByLogin == null){
            // add 404 return
        }
        else{
            if(userByLogin.getPassword().equals(password)){
                return userByLogin;
            }
        }
        return null;
    }

    public User getUserByLogin(String login){
        return userRepository.findUserByLogin(login);
    }

}
