package com.academia.model.service;

import com.academia.model.dao.EmailDAO;

public class EmailService {
    public static void enviarEmailMatricula(String email, String nome) {
        System.out.println(nome);
        System.out.println(email);
        String assunto, mensagem;
        assunto = "Matricula Realizada - EliteFIt";
        mensagem = "<img src=\"https://i.imgur.com/h68jOwG.png\" width=\"77px\" height=\"47px\"><strong><h3>Academia Elite Fit</h3></strong>Olá "+ nome +"<br> Nós, da equipe EliteFit, queremos antes de qualquer coisa te <strong>parabenizar</strong> pela importante decisão que você tomou hoje. <strong>(Investir em Você)</strong>!<br> Viemos informar que seu cadastro foi realizado, e você já consegue ter acesso ao site/app e a nossas unidades. <br><br> Bom treino!<br>att. Equipe EliteFit";
        EmailDAO.enviarEmail(email, assunto, mensagem);
    }
    public static void enviarEmailExercicio(String email, String nome) {
        String assunto, mensagem;
        assunto = "Matricula Realizada - EliteFIt";
        mensagem = "<img src=\"https://i.imgur.com/h68jOwG.png\" width=\"77px\" height=\"47px\"><strong><h3>Academia Elite Fit</h3></strong>Olá "+ nome +"!<br> Viemos informar que sua ficha técnica já foi feita!<br>Você consegue visualizá-la tanto pelo site quanto pelo App.<br><br> Bom treino!<br>att. Equipe EliteFit";
        EmailDAO.enviarEmail(email, assunto, mensagem);
    }
}
