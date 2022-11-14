package academiawb.model.service;

import academiawb.model.dao.CatracaDAO;

public class CatracaService {

    public static Integer login(String login, String senha) {
        return CatracaDAO.buscaLogin(login, senha);
    }
    public static void adicionaCatraca(Integer id) {
        CatracaDAO.inserirCatraca(id);
    }
    public static String getNome(Integer id) {
        return CatracaDAO.getNome(id);
    }
    public static String getPlano(Integer id) {
        return CatracaDAO.getPlano(id);
    }
}