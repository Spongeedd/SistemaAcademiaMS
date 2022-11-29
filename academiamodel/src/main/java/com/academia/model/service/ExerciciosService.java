package com.academia.model.service;

import com.academia.model.dao.ExerciciosDAO;
import com.academia.model.dto.ExerciciosDTO;

public class ExerciciosService {
    public static ExerciciosDTO adicionarExercicios(String plano, String descricao, String serie, String repeticoes) {
        return ExerciciosDAO.inserirExercicios(plano, descricao, serie, repeticoes);
    }

    public static void removerExercicio(Integer codigo) {
        ExerciciosDAO.removeExercicio(codigo);
    }
    
    public static void atribuirExercicio (Integer idExercicio, Integer idMatricula) {
        ExerciciosDAO.atribuirExercicios(idMatricula, idExercicio);  
    }
    
        public static void desatribuirExercicios (Integer idMatricula) {
        ExerciciosDAO.desatribuirExercicios(idMatricula);  
    }
}
