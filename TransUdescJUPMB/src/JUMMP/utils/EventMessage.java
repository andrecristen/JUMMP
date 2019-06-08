/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUMMP.utils;

import javax.swing.JOptionPane;

/**
 * Responsavel por facilitar nossas mensagens ao usuário no sistema
 * @author André Cristen
 */
public class EventMessage {
    
    final static int TIPO_SUCESSO = 1;
    final static int TIPO_ERRO    = 2;
    final static int TIPO_WARNING = 3;
 
    
    protected String message;
    
    protected int tipo; 

    public EventMessage(String message, int tipo) {
        this.message = message;
        this.tipo = tipo;
        switch(tipo){
            case (TIPO_SUCESSO):
                 JOptionPane.showMessageDialog(null,
                    message,
                    "Sucesso na operação!",
                    JOptionPane.INFORMATION_MESSAGE);
                break;
            case (TIPO_ERRO):
                JOptionPane.showMessageDialog(null,
                    message,
                     "Erro na operação!",
                    JOptionPane.ERROR_MESSAGE);
                break; 
            case (TIPO_WARNING):
                JOptionPane.showMessageDialog(null,
                    message,
                    "Atenção!",
                    JOptionPane.WARNING_MESSAGE);
                break; 
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int setTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public static int getTIPO_SUCESSO() {
        return TIPO_SUCESSO;
    }

    public static int getTIPO_ERRO() {
        return TIPO_ERRO;
    }

    public static int getTIPO_WARNING() {
        return TIPO_WARNING;
    }
    
}
