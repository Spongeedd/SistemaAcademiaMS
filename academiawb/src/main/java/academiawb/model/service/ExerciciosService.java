package academiawb.model.service;

import academiawb.model.dao.ExerciciosDAO;
import academiawb.model.dto.ExerciciosDTO;


public class ExerciciosService {
    public static ExerciciosDTO adicionarExercicios(String plano, String descricao, String serie, String repeticoes) {
        return ExerciciosDAO.inserirExercicios(plano, descricao, serie, repeticoes);
    }

    public static void removerExercicio(Integer codigo) {
        ExerciciosDAO.removeExercicio(codigo);
    }
    
    public static void atribuirExercicio (Integer idExercicio, Integer idMatricula) {
        ExerciciosDAO.atribuirExercicios(idExercicio, idMatricula);
    
}
}