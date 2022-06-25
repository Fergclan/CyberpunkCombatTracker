package com.example.cyberpunkcombattracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CyberpunkApplication extends Application
{
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainScene-view.fxml"));
        Parent stage = fxmlLoader.load();
        MainController mainController = fxmlLoader.getController();

        primaryStage.setScene(new Scene(stage));
        primaryStage.setMinHeight(300.0);
        primaryStage.setMinWidth(300.0);

        primaryStage.widthProperty().addListener((observableValue, number, t1) -> mainController.fixResolution(primaryStage.getWidth()));

        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}