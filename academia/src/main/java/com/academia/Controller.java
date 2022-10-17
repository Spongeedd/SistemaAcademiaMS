package com.academia;

import java.io.IOException;
import javafx.fxml.FXML;

public class Controller {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}