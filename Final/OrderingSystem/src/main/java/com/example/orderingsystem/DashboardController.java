package com.example.orderingsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class DashboardController {
    @FXML
    private BorderPane rootPane;

    @FXML
    private void onClickHome () { loadPage("HomePage.fxml");}

    @FXML
    private void onClickMenu() {loadPage("Menu.fxml");}

    @FXML
    private void onClickTran() {loadPage("AllMenus.fxml");}



    private void loadPage(String fxml) {

        try {
            var root = FXMLLoader.load(Main.class.getResource(fxml));
            assert rootPane != null;
            rootPane.setCenter((Node) root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
