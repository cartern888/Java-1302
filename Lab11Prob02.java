/**
* File: Lab11Prob02.java
* Class: CSCI 1302
* Author: William Carter
* Created on: Apr 24, 2026
* Last Modified: Apr 24, 2026
* Description: Binary I/O
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11Prob02 {

    public static void main(String[] args) {

        ArrayList<Person> list = new ArrayList<>();

        try {
            DataInputStream input = new DataInputStream(
                    new FileInputStream("src/people.dat"));

            while (true) {

                int age = input.readInt();
                String name = input.readUTF();
                String address = input.readUTF();
                int zip = input.readInt();
                double salary = input.readDouble();

                Person p = new Person(age, name, address, zip, salary);
                list.add(p);
            }

        } catch (EOFException e) {
            System.out.println("done");

        } catch (IOException e) {
            System.out.println("read error");
        }

        Collections.sort(list);

        try {
            DataOutputStream output = new DataOutputStream(
                    new FileOutputStream("people-salary-sorted.dat"));

            for (int i = 0; i < list.size(); i++) {
                output.writeUTF(list.get(i).toString());
            }

            output.close();

        } catch (IOException e) {
            System.out.println("write error");
        }
    }
}