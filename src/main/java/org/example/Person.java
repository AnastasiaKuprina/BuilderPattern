package org.example;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String city;


    private Person (PersonBuilder builder) {
        this.name = builder.name;
        this.surname = builder.surName;
        this.age = builder.age;
        this.city = builder.city;
    }


    public boolean hasAge() {
        return this.age >= 0;
    }

    public boolean hasAddress() {
        return !(this.city == null);
    }


    // геттеры
    public String getName() {
        return name;
    }

    public String getSurName() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return city;
    }

    // сеттеры
    public void setAddress(String city) {
        this.city = city;
    }
    public void happyBirthday() {
        if (hasAge()) {
            this.age++;
        }
    }

    // Логика по возрасту
    public void setAge(int age) {
        if (hasAge()) {
            throw new IllegalStateException("Возраст уже установлен, дальше через happyBirthday()");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Некорректное значение возраста");
        }
        this.age = age;
    }


    @Override
    public String toString() {
        return name + ' ' +
                surname +
                " (возраст: " + age + ')';
    }



    public static class PersonBuilder  {
        // Необходимые параметры
        private String name;
        private String surName;

        // Необязательные параметры
        private int age = -1;
        private String city = null;

        public PersonBuilder () {}

        public PersonBuilder  setName(String name) {
            if (this.name != null) {
                throw new IllegalStateException("Имя уже есть\n");
            }
            this.name = name;
            return this;
        }

        public PersonBuilder  setSurname(String surName) {
            if (this.surName != null) {
                throw new IllegalStateException("Фамилия уже есть\n");
            }
            this.surName = surName;
            return this;
        }

        public PersonBuilder  setAge(int age) {
            if (this.age >= 0) {
                throw new IllegalStateException("Возраст уже введен\n");
            }
            if (age < 0) {
                throw new IllegalArgumentException("Возраст меньше нуля!\n");
            }
            this.age = age;
            return this;
        }

        public PersonBuilder  setAddress(String city) {
            if (this.city != null) {throw new IllegalStateException("Город уже задан\n");}
            this.city = city;
            return this;
        }

        public Person build() {
            if (this.name == null || this.surName == null) {
                throw new IllegalStateException("Имя и Фамилия обязательны\n");
            }
            return new Person(this);
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
//        child.setSurname(this.surname);
//        child.setAddress(this.city);
 //       child.setAge(1);
        return child;
    }
}