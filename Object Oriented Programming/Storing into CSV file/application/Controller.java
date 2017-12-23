package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Controller {
    private static ArrayList<Person> people = new ArrayList<>();

    @FXML
    private TextField nameTextField, emailTextField, phoneTextField;

    @FXML
    private void createInstances(ActionEvent event) {
        String name, email, phone;
        name = nameTextField.getText();
        email = emailTextField.getText();
        phone = phoneTextField.getText();

        int fields = 3;
        if(name.equals("")) {
            nameTextField.setPromptText("Enter your name, please.");
            fields--;
        }

        if(email.equals("")) {
            emailTextField.setPromptText("Enter your email, please.");
            fields--;
        }

        if(phone.equals("")) {
            phoneTextField.setPromptText("Enter your phone number, please.");
            fields--;
        }

        if(fields > 2) {
            Person person = new Person(name, email, phone);
            if(!people.contains(person)) {
                people.add(person);
                System.out.println(person.name + " was created.");
            }
        }
    }

    @FXML
    private void saveToCSV(ActionEvent event) {
        if(people.size() != 0) {
            printAliases(people);
            Path path = Paths.get(System.getProperty("user.dir") + "\\people.csv");
            try(BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE)) {
                for(Person person: people) {
                    writer.write(person.toString());
                    writer.newLine();
                }
                System.out.println("people.csv was created!");
            } catch(IOException e) {
                System.err.format("IOException: %s%n", e);
            }
        }
    }

    // TODO Make a pop-up for printAliases
    private static void printAliases(ArrayList<Person> people) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n%-25s%-25s%s\n", "Name", "E-mail", "Phone"));
        for(Person person: people)
            sb.append(String.format("%-25s%-25s%s\n", person.name, person.email, person.phone));
        System.out.println(sb.toString());
    }
}