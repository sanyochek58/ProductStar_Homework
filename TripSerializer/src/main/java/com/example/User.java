package com.example;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String surname;
    private final String firstName;
    private final int age;
    private final String sex;

    transient private final String numberPassport;
    transient private final String codePassport;

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getNumberPassport() {
        return numberPassport;
    }

    public String getCodePassport() {
        return codePassport;
    }

    public static final class Builder{

        private String surname;
        private String firstName;
        private int age;
        private String sex;
        private String numberPassport;
        private String codePassport;

        Builder(String surname){
            this.surname = surname;
        }

        Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        Builder age(int age){
            this.age = age;
            return this;
        }

        Builder sex(String sex){
            this.sex = sex;
            return this;
        }

        Builder numberPassport(String numberPassport){
            this.numberPassport = numberPassport;
            return this;
        }

        Builder codePassport(String codePassport){
            this.codePassport = codePassport;
            return this;
        }

        User build(){
            return new User(this);
        }
    }

    private User(Builder builder){
        this.surname = builder.surname;
        this.firstName = builder.firstName;
        this.age = builder.age;
        this.sex = builder.sex;
        this.numberPassport = builder.numberPassport;
        this.codePassport = builder.codePassport;
    }

    @Override
    public String toString() {
        return "---------------------------------------------\n" +
                "Информация о пользователе: \n" +
                "Фамилия - " + getSurname() + "\n" +
                "Имя - " + getFirstName() + "\n" +
                "Возраст - " + getAge() + " лет \n" +
                "Пол - " + getSex() +  "\n" +
                "Номер паспорта - " + getNumberPassport() + "\n" +
                "Серия паспорта - " + getCodePassport() + "\n" +
                "---------------------------------------------\n";
    }
}
