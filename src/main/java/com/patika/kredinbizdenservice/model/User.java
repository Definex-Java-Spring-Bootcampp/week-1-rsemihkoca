package com.patika.kredinbizdenservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class User {

    @Getter @Setter private String name;
    @Getter @Setter private String surname;
    @Getter @Setter private LocalDate birthDate;
    @Getter private String email;
    private String password;
    @Getter @Setter private String phoneNumber;
    @Getter @Setter private Boolean isActive;

    private static final Set<String> registeredEmails = new HashSet<>();


    private User(String name,
                String surname,
                LocalDate birthDate,
                String email,
                String password,
                String phoneNumber,
                Boolean isActive) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = setEmail(email);
        this.password = setPassword(password);
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }

    public static User create(
            String name,
            String surname,
            LocalDate birthDate,
            String email,
            String password,
            String phoneNumber,
            Boolean isActive) {
        return new User(name, surname, birthDate, email, password, phoneNumber, isActive);
    }

    private String setEmail(String email) {
        if (registeredEmails.contains(email)) {
            throw new IllegalArgumentException("Email is already registered.");
        }
        registeredEmails.add(email);
        return email;
    }


    private String setPassword(String password) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            return new String(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isActive=" + isActive +
                '}';
    }

}
