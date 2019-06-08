package main;

import JUMMP.authorization.FormLogin;

/**
 *@author 09046167976 
 * início do sistema, instancia a tela de login e seta como visivel.
 * O nome da persistence deve ser definido aqui na constante.
 */
public class Home implements Runnable {
   
   final static String PERSISTENCE_NAME = "JUMMPPU";
   final static String SYSTEM_NAME = "TransUdesc - JUMMP";
   
   public static void main(String[] args) throws Exception {
       Home tela = new Home();
       Thread thread = new Thread(tela);
       thread.start();
    }

    @Override
    public void run() {
        FormLogin login = new FormLogin();
        login.setVisible(true);
    }

    public static String getPesistenceName() {
        return PERSISTENCE_NAME;
    }

    public static String getSystemName() {
        return SYSTEM_NAME;
    }
    
    
}
