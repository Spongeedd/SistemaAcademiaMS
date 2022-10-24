module com.academia {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.academia to javafx.fxml;
    opens com.academia.funcionario to javafx.fxml;
    
    exports com.academia;
    exports com.academia.funcionario;
}
