package com.example.test1b;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField usernamesss;

    @FXML
    private TextField userpasswordsss;

    @FXML
    private Label welcomeText;

    private int failedAttempts = 0; // Counter for failed login attempts
    private final int MAX_ATTEMPTS = 5; // Maximum allowed attempts before locking

    public void login(ActionEvent actionEvent) {
        String username = usernamesss.getText();
        String password = userpasswordsss.getText();

        // Check if username or password is empty
        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Please enter Username and Password");
            return;
        }

        // Check if account is locked
        if (failedAttempts >= MAX_ATTEMPTS) {
            showAlert("Sorry, Your Account is Locked!!!");
            return;
        }

        // Authentication logic: Replace with your desired username/password
        if (username.equals("YOUR_NAME") && password.equals("456")) {
            showAlert("Login Successful!");
            failedAttempts = 0; // Reset failed attempts after successful login
        } else {
            failedAttempts++; // Increment failed attempts on incorrect credentials
            showAlert("Sorry, Invalid Username or Password. Attempt " + failedAttempts + " of " + MAX_ATTEMPTS);

            // Display message if account gets locked after exceeding max attempts
            if (failedAttempts >= MAX_ATTEMPTS) {
                showAlert("Sorry, Your Account is Locked!!!");
            }
        }
    }

    // Method to display alert messages
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
