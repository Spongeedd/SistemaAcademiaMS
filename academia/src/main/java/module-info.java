module com.academia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
//    requires academiamodel;

//    opens com.academia to javafx.fxml, java.sql, academiamodel;
//    opens com.academia.funcionario to javafx.fxml, academiamodel;
//    opens com.academia.matricula to javafx.fxml, academiamodel;    

//    exports com.academia;
//    exports com.academia.funcionario;
//    exports com.academia.matricula;
    

    opens com.academia to javafx.fxml, java.sql;
    opens com.academia.funcionario to javafx.fxml;
    opens com.academia.matricula to javafx.fxml;

    exports com.academia;
    exports com.academia.funcionario;
    exports com.academia.matricula;    
    
}
