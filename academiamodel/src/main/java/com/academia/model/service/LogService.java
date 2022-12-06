package com.academia.model.service;

import com.academia.model.dao.LogDAO;
import com.academia.model.dto.LogDTO;

public class LogService {
    public static void inserirLog(String acao) {    
        LogDAO.inserirLog(acao);
    }

    public static LogDTO setUsuario(String usuario) {
        return LogDAO.setUsuario(usuario);
    }
    public static String getUsuario() {
        return LogDAO.getUsuario();
    }

}
