/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUMMP.authorization;

import models.Usuario;

/**
 *
 * @author andre
 */
public class Session {
    
    private static Usuario user;
    
    private Session() {
    }
    
    public static Session getInstance() {
        return SessionSingleHolder.INSTANCE;
    }
    
    private static class SessionSingleHolder {

        private static final Session INSTANCE = new Session();
    }

    public static Usuario getUser() {
        return user;
    }

    public static void setUser(Usuario user) {
        Session.user = user;
    }
    
}
