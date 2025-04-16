package com.example.orderingsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Font;

public class MenuController {

    // FXML Elements
    @FXML
    private Label foodNamePrice1, foodNamePrice2, foodNamePrice3, foodNamePrice4, foodNamePrice5, foodNamePrice6;
    @FXML
    private Spinner<Integer> spinner1, spinner2, spinner3, spinner4, spinner5, spinner6;
    @FXML
    private ListView<String> orderList;
    @FXML
    private Label totalLabel;

    // Sample prices (you can replace them with actual prices)
    private double price1 = 150.00;
    private double price2 = 200.00;
    private double price3 = 250.00;
    private double price4 = 300.00;
    private double price5 = 350.00;
    private double price6 = 400.00;

    // Observable list for order items
    private ObservableList<String> orderListData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Set spinner values (quantity range from 0 to 10)
        spinner1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0));
        spinner2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0));
        spinner3.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0));
        spinner4.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0));
        spinner5.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0));
        spinner6.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0));

        // Initialize the order list
        orderList.setItems(orderListData);
    }

    @FXML
    private void addItem1(ActionEvent event) {
        int quantity = spinner1.getValue();
        if (quantity > 0) {
            double total = price1 * quantity;
            orderListData.add("Food 1 x" + quantity + " - ₱" + total);
            updateTotal();
        }
        spinner1.getValueFactory().setValue(0);  // Reset the spinner to 0
    }

    @FXML
    private void addItem2(ActionEvent event) {
        int quantity = spinner2.getValue();
        if (quantity > 0) {
            double total = price2 * quantity;
            orderListData.add("Food 2 x" + quantity + " - ₱" + total);
            updateTotal();
        }
        spinner2.getValueFactory().setValue(0);  // Reset the spinner to 0
    }

    @FXML
    private void addItem3(ActionEvent event) {
        int quantity = spinner3.getValue();
        if (quantity > 0) {
            double total = price3 * quantity;
            orderListData.add("Food 3 x" + quantity + " - ₱" + total);
            updateTotal();
        }
        spinner3.getValueFactory().setValue(0);  // Reset the spinner to 0
    }

    @FXML
    private void addItem4(ActionEvent event) {
        int quantity = spinner4.getValue();
        if (quantity > 0) {
            double total = price4 * quantity;
            orderListData.add("Food 4 x" + quantity + " - ₱" + total);
            updateTotal();
        }
        spinner4.getValueFactory().setValue(0);  // Reset the spinner to 0
    }

    @FXML
    private void addItem5(ActionEvent event) {
        int quantity = spinner5.getValue();
        if (quantity > 0) {
            double total = price5 * quantity;
            orderListData.add("Food 5 x" + quantity + " - ₱" + total);
            updateTotal();
        }
        spinner5.getValueFactory().setValue(0);  // Reset the spinner to 0
    }

    @FXML
    private void addItem6(ActionEvent event) {
        int quantity = spinner6.getValue();
        if (quantity > 0) {
            double total = price6 * quantity;
            orderListData.add("Food 6 x" + quantity + " - ₱" + total);
            updateTotal();
        }
        spinner6.getValueFactory().setValue(0);  // Reset the spinner to 0
    }

    // Method to calculate and update total price
    private void updateTotal() {
        double total = 0;
        for (String item : orderListData) {
            // Extracting the price from the order string
            String[] parts = item.split(" - ₱");
            total += Double.parseDouble(parts[1]);
        }
        totalLabel.setText("₱" + total);
    }

    @FXML
    private void clearOrder(ActionEvent event) {
        orderListData.clear();
        totalLabel.setText("₱0.00");
    }

    @FXML
    private void placeOrder(ActionEvent event) {
        // Create a confirmation alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText("Are you sure you want to place the order?");
        alert.setContentText("Your total order amount is " + totalLabel.getText());

        // Show the alert and wait for user response
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                // Place order logic (e.g., save order to a database or process payment)
                System.out.println("Order placed!");
                // Optionally, clear the order after placing
                clearOrder(event);
            } else {
                // If user cancels the order, no action is taken
                System.out.println("Order canceled.");
            }
        });
    }
}
