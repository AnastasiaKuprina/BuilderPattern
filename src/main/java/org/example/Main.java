package org.example;

public class Main {
    public static void main(String[] args) {
        Person mom = new Person.PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .setSurname("Вольф")
                .setAge(1)
                .build();

        System.out.println("У " + mom + " есть сын, " + son);
    }
}