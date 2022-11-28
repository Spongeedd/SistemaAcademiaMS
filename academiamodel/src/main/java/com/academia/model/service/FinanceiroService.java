package com.academia.model.service;

import java.text.ParseException;

import com.academia.model.dao.FinanceiroDAO;
import com.academia.model.dto.FinanceiroDTO;

public class FinanceiroService {
    public static FinanceiroDTO caculaDebitos() {
       return FinanceiroDAO.caculaDebitos();
    }

    public static FinanceiroDTO calculaFaturamento() {
        return FinanceiroDAO.calculaFaturamento();
    }

    public static void calculaReceita() throws ParseException {
        FinanceiroDAO.calculaReceita();
    }

    public static Integer getFaturamento() {
        return FinanceiroDAO.getFaturamento();
    }

    public static Integer getPagamentos() {
        return FinanceiroDAO.getPagamentos();
    }

    public static Integer getReceita() {
        return FinanceiroDAO.getReceita();
    }
}    
