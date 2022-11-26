package academiawb.model.service;

import academiawb.model.dao.FinanceiroDAO;
import academiawb.model.dto.FinanceiroDTO;

public class FinanceiroService {
    public static FinanceiroDTO caculaDebitos() {
       return FinanceiroDAO.caculaDebitos();
    }

    public static FinanceiroDTO calculaFaturamento() {
        return FinanceiroDAO.calculaFaturamento();
    }

    public static void calculaReceita() {
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
