/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUMMP.authorization;

import JUMMP.utils.EventMessage;
import controllers.UsuarioController;
import java.awt.Window;
import models.Usuario;

/**
 *
 * @author André Cristen Faz a validacao de login com base nos dados da tela de
 * login
 */
public class SessionAuth {

    private String login;
    private String senha;

    public SessionAuth(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public SessionAuth() {

    }

    /**
     * Valida se os dados informados coincidem com de algum usuario
     *
     * @return
     */
    public boolean login() {
        UsuarioController userControll = new UsuarioController();
        Usuario user = userControll.validarLogin(this.login, this.senha);
        if (user.getId() >= 1) {
            Session.setUser(user);
            return true;
        }
        return false;
    }

    /**
     * Limpa o usuario da sessao e fecha todas as telas do sistema abre
     * novamente a tela de login.
     */
    public void logout() {
        try {
            Session.setUser(new Usuario());
            FormLogin formLogin = new FormLogin();
            closeAllWindows();
            formLogin.setVisible(true);
            new EventMessage("Usuário deslogado do sistema", EventMessage.getTIPO_SUCESSO());
        } catch (Exception exception) {
            new EventMessage("Erro ao sair do sistema", EventMessage.getTIPO_ERRO());
        }
    }

    public static void closeAllWindows() {
        //Fecha todas os Frames abertos e limpa o lixo.
        System.gc();
        for (Window window : Window.getWindows()) {
            window.dispose();
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
