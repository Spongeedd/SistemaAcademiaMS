package academiawb.model.service;

import academiawb.model.dao.MatriculaDAO;
import academiawb.model.dto.MatriculaDTO;
import java.sql.Date;

public class MatriculaService {

    public static MatriculaDTO adicionarMatricula(String nome, String cpf, Date datanascimento, String endereco, String telefone, String email, String plano, String pacote) {
        return MatriculaDAO.inserirMatricula(nome, cpf, datanascimento, endereco, telefone, email, plano, pacote);
    }

    public static void removerMatricula(Integer codigo) {
        MatriculaDAO.removeMatricula(codigo);
    }

    public static void editarMatricula(Integer codigo,String nome, String cpf, Date datanascimento, String endereco, String telefone, String email, String plano, String pacote) {
        MatriculaDAO.atualizaMatricula(codigo ,nome, cpf, datanascimento, endereco, telefone, email, plano, pacote);
    }

    public static Integer consultaPorID(Integer codigo) {
        return MatriculaDAO.consultaPorID(codigo);
    }

    public static String consultaPorNome(String nome) {
        return MatriculaDAO.consultaPorNome(nome);
    }

    public static String consultaPorCPF(String cpf) {
        return MatriculaDAO.consultaPorCPF(cpf);
    }
}
