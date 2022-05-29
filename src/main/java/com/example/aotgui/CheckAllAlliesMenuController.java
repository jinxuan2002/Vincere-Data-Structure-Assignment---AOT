package com.example.aotgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CheckAllAlliesMenuController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField characteristicsTextField;
    @FXML
    private Button addCharacterButton;
    @FXML
    private Button backToPreviousButton;
    @FXML
    private Button displayAllAlliesButton;
    @FXML
    private Label resultLabel;
    @FXML
    private Label nameErrorLabel;
    @FXML
    private Label characteristicsErrorLabel;

    private MainApplication main;
    private String name;
    private String characteristics;
    LinkedList<Character> charactersList = new LinkedList<>();

    public void setApp(MainApplication main) {
        this.main = main;
    }

    public void displayAllAllies() throws Exception {
        main.goToDisplayAllAlliesMenu();
    }

    public void backToPrevious() throws Exception {
        main.goToLoginMenu();
    }

    public void addCharacter() throws Exception {
        try {
            name = nameTextField.getText();
            characteristics = characteristicsTextField.getText();
            boolean shouldReturn = false;

            if (!isMatchingNameInputFormat(name)) {
                nameErrorLabel.setText("Incorrect format for name!");
                shouldReturn = true;
            } else {
                nameErrorLabel.setText("");
            }

            if (!isMatchingCharacteristicsStringInputFormat(characteristics)) {
                characteristicsErrorLabel.setText("Incorrect format for characteristics!");
                shouldReturn = true;
            } else {
                characteristicsErrorLabel.setText("");
            }

            if (shouldReturn)
                return;

            if (!isRepeated(name, characteristics)) {
                storeToTextFile(name, characteristics);
                String[] values = characteristics.split(" ");
                int height = Integer.parseInt(values[0]);
                int weight = Integer.parseInt(values[1]);
                int strength = Integer.parseInt(values[2]);
                int agility = Integer.parseInt(values[3]);
                int intelligence = Integer.parseInt(values[4]);
                int coordination = Integer.parseInt(values[5]);
                int leadership = Integer.parseInt(values[6]);
                Character character = new Character(name, height, weight, strength, agility, intelligence, coordination, leadership);
                charactersList.add(character);
                String temp = "Name: " + name
                        + "\nHeight: " + height + "cm"
                        + "\nWeight: " + weight + "kg"
                        + "\nStrength: " + height
                        + "\nAgility: " + height
                        + "\nIntelligence: " + height
                        + "\nCoordination: " + coordination
                        + "\nLeadership: " + leadership;

                resultLabel.setText(temp);
            }
            else {
                resultLabel.setText("Character is already inside the database!");
            }
        } catch (Exception e) {
            resultLabel.setText(String.valueOf(e));
        }
    }

    private static boolean isMatchingNameInputFormat(String name) {
        return name.matches("([A-Z]\\w+\\s*) ([A-Z]\\w+\\s*)");
    }

    private static boolean isMatchingCharacteristicsStringInputFormat(String characteristicsString) {
        return characteristicsString.matches("\\d+ \\d+ \\d+ \\d+ \\d+ \\d+ \\d+");
    }

    private static boolean isRepeated(String name, String characteristics) throws FileNotFoundException {
        try {
            Scanner input = new Scanner(new FileInputStream("C:\\Users\\Asus\\IdeaProjects\\aotgui\\src\\characters.txt"));
            while (input.hasNextLine()) {
                String checkedName = input.nextLine();
                if (input.hasNextLine()) {
                    String checkedCharacteristics = input.nextLine();
                    if (checkedName.equals(name) && checkedCharacteristics.equals(characteristics)) {
                        input.close();
                        return true;
                    }
                } else {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            throw e;
        }
        return false;
    }

    private static boolean storeToTextFile(String name, String characteristics) throws FileNotFoundException {
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream("C:\\Users\\Asus\\IdeaProjects\\aotgui\\src\\characters.txt", true));
            writer.println(name);
            writer.println(characteristics);
            writer.close();
            return true;
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
