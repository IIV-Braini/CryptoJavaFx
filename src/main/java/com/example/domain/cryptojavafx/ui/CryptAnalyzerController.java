package com.example.domain.cryptojavafx.ui;

import com.example.domain.cryptojavafx.domain.utils.Encoder;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static java.lang.Integer.*;

public class CryptAnalyzerController {
    @FXML
    private Label labelTextEncode;
    @FXML
    private Label labelTextDecode;
    @FXML
    private Label labelTextBruteforce;
    @FXML
    public TextField filePathEncode;
    @FXML
    public TextField filePathDecode;
    @FXML
    public TextField filePathBruteforce;
    @FXML
    public TextField keyEncode;
    @FXML
    public TextField keyDecode;
    @FXML
    public TextField filePathAnalyzed;

    private final Encoder encoder = new Encoder();

    @FXML
    protected void onEncodeButtonClickRun() {
        String fileIn = filePathEncode.getText();
        String fileOut = fileIn.replace(".txt", "(encoded).txt");
        int key = parseInt(keyEncode.getText());
        try {
            encoder.encode(fileIn, fileOut, key);
            labelTextEncode.setText("Encode Done!");
        } catch (RuntimeException e) {
            labelTextEncode.setText("Error program");
        }
    }

    @FXML
    protected void onDecodeButtonClickRun() {
        String fileIn = filePathDecode.getText();
        String fileOut = fileIn.replace("encoded", "decoded");
        int key = parseInt(keyDecode.getText());
        try {
            encoder.decode(fileIn, fileOut, key);
            labelTextDecode.setText("Decode Done!");
        } catch (RuntimeException e) {
            labelTextDecode.setText("Error program");
        }
    }

    @FXML
    protected void onBruteForceButtonClickRun() {
        String file = filePathBruteforce.getText();
        String fileAnalysis = filePathAnalyzed.getText();
        try {
            encoder.encodeWithAnalysis(file, fileAnalysis);
            labelTextBruteforce.setText("Bruteforce Done!");
        } catch (RuntimeException e) {
            labelTextBruteforce.setText("Error program");
        }
    }
}