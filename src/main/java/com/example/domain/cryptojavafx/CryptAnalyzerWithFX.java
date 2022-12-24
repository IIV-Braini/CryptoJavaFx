package com.example.domain.cryptojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CryptAnalyzerWithFX extends Application {
        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(CryptAnalyzerWithFX.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 350);
            stage.setTitle("КриптоАнализатор!");
            stage.setScene(scene);
            stage.show();
        }

    public static void main(String[] args) {
        launch();
    }
}