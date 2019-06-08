/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import models.Carregamento;
import JUMMP.forms.BaseForm;
import views.forms.FormCarregamento;
import JUMMP.utils.EventMessage;

/**
 *
 * @author Lucas Dolsan
 * 
 * tem todas as funcionalidades do baseController
 */
public class CarregamentoController extends BaseController {
    
    public Class createInstaceModel() {
        return Carregamento.class;
    }
    
    public BaseForm createInstaceView() {
        return new FormCarregamento(this.getAction());
    }

    @Override
    public Object beanModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public EventMessage testeAction(Object param){
        System.out.println(param);
        return new EventMessage("Funciona fdp", EventMessage.getTIPO_SUCESSO());
    }

    @Override
    public void beanForm(BaseForm view, Object model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
