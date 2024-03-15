package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserFactory {

    private static volatile UserFactory instance;
    private List<User> userList = new ArrayList<>();

    private UserFactory() {
    }

    public static UserFactory getInstance() {
        if (instance == null) {
            synchronized (UserFactory.class) {
                if (instance == null) {
                    instance = new UserFactory();
                }
            }
        }
        return instance;
    }

    public User create(String name,
                       String surname,
                       LocalDate birthDate,
                       String email,
                       String password,
                       String phoneNumber,
                       Boolean isActive) {

        User user = User.create(name, surname, birthDate, email, password, phoneNumber, isActive);

        userList.add(user);

        return user;

    }


}

