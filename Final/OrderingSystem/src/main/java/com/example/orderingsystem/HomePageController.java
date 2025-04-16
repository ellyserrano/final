package com.example.orderingsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomePageController {

    @FXML
    private Button shopButton;

    @FXML
    private Button aboutButton;

    @FXML
    private Button contactButton;

    @FXML
    private void initialize() {
        // Set button actions
        shopButton.setOnAction(e -> goToShop());
        aboutButton.setOnAction(e -> goToAboutUs());
        contactButton.setOnAction(e -> goToContactUs());
    }

    private void goToShop() {
        System.out.println("Navigating to Shop Now...");
        // Code to switch to the Shop page
    }

    private void goToAboutUs() {
        System.out.println("Navigating to About Us...");
        // Code to switch to the About Us page
    }

    private void goToContactUs() {
        System.out.println("Navigating to Contact Us...");
        // Code to switch to the Contact Us page
    }
}
