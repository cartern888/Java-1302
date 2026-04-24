import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11Prob03 {

    public static void main(String[] args) {

        // person list
        ArrayList<Person> list = new ArrayList<>();

        // read file
        try {
            DataInputStream input = new DataInputStream(
                    new FileInputStream("src/people.dat"));

            while (true) {

                int age = input.readInt();
                String name = input.readUTF();
                String address = input.readUTF();
                int zip = input.readInt();
                double salary = input.readDouble();

                list.add(new Person(age, name, address, zip, salary));
            }

        } catch (EOFException e) {
            System.out.println("done");

        } catch (IOException e) {
            System.out.println("read error");
        }

        // sort list
        Collections.sort(list);

        // write binary objects
        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream("people-salary-sorted-objects.dat"))) {

            for (Person p : list) {
                out.writeObject(p);
            }

        } catch (IOException e) {
            System.out.println("write error");
        }
    }
}