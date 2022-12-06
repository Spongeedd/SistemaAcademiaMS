package com.academia.model.service;

import java.text.ParseException;

import com.academia.model.dao.CobrancaDAO;
import com.academia.model.dto.CobrancaDTO;

public class CobrancaService {
    public static void adicionaCobranca() throws ParseException {
        CobrancaDAO.inserirCobranca();
    }
    
    public static void quitarCobranca(Integer id) {
        CobrancaDAO.removerCobranca(id);
    }

    public static Boolean verificaStatus(Integer id) {
        return CobrancaDAO.verificaStatus(id);
    }

    public static CobrancaDTO setUsuario(Integer id) {
        return CobrancaDAO.setUsuario(id);
    }

    public static Integer getUsuario() {
        return CobrancaDAO.getUsuario();
    }
}
