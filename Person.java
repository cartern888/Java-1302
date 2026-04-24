/**
* File: Person.java
* Class: CSCI 1302
* Author: William Carter
* Created on: Apr 24, 2026
* Last Modified: Apr 24, 2026
* Description: Binary I/O
*/

import java.io.Serializable;

public class Person implements Comparable<Person>, Serializable {

    // data fields
    private int age;
    private String name;
    private String address;
    private int zip;
    private double salary;

    // default constructor
    public Person() {}

    // full constructor
    public Person(int age, String name, String address, int zip, double salary) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.salary = salary;
    }

    // getters
    public int getAge() { return age; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public int getZip() { return zip; }
    public double getSalary() { return salary; }

    // setters
    public void setAge(int age) { this.age = age; }
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setZip(int zip) { this.zip = zip; }
    public void setSalary(double salary) { this.salary = salary; }

    // compare salary
    @Override
    public int compareTo(Person other) {
        if (this.salary < other.salary) return 1;
        if (this.salary > other.salary) return -1;
        return 0;
    }

    // to string
    @Override
    public String toString() {
        return age + " " + name + " " + address + " " + zip + " " +
                String.format("$%,.2f", salary);
    }
}