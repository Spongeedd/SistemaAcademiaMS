module com.academia {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;

    opens com.academia to javafx.fxml, java.sql;
    opens com.academia.funcionario to javafx.fxml;
    opens com.academia.matricula to javafx.fxml;
    opens com.academia.db to java.sql;

    exports com.academia;
    exports com.academia.funcionario;
    exports com.academia.matricula;
    exports com.academia.db;
}
