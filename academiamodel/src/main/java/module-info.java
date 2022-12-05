module academiamodel {
    
    requires java.sql;
    requires java.mail;
    
    exports com.academia.model.dto;
    exports com.academia.model.dao;
    exports com.academia.model.db;
    exports com.academia.model.service;
}