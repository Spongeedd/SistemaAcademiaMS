module com.academia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires de.jensd.fx.glyphs.commons;
    requires academiamodel;
    
    opens com.academia to javafx.fxml, java.sql;
    opens com.academia.funcionario to javafx.fxml;
    opens com.academia.matricula to javafx.fxml;
    opens com.academia.catraca to javafx.fxml;
    opens com.academia.exercicios to javafx.fxml;
    opens com.academia.dashboard to javafx.fxml;
    opens com.academia.fatura to javafx.fxml;

    exports com.academia;
    exports com.academia.funcionario;
    exports com.academia.matricula;    
    exports com.academia.catraca;
    exports com.academia.exercicios;
    exports com.academia.dashboard;
    exports com.academia.fatura;
}
