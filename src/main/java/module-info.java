module com.example.domain.cryptojavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.domain.cryptojavafx to javafx.fxml;
    exports com.example.domain.cryptojavafx;
    exports com.example.domain.cryptojavafx.ui;
    opens com.example.domain.cryptojavafx.ui to javafx.fxml;
}