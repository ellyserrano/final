package com.example.orderingsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MenusDashboard {
    @FXML
    private BorderPane rootPane2;

    @FXML
    private void onClickCombo () { loadPage("ComboMeals.fxml");}



    private void loadPage(String fxml) {

        try {
            var root = FXMLLoader.load(Main.class.getResource(fxml));
            assert rootPane2 != null;
            rootPane2.setCenter((Node) root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
