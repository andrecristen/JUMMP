/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import java.util.ArrayList;
import java.util.List;
import models.Endereco;
import models.TransportadoraRedespacho;
import JUMMP.forms.BaseForm;
import views.forms.FormTransRedespacho;

/**
 *
 * @author Lucas Dolsan
 */
public class TransportadoraRedespachoController extends BaseController {

    @Override
    public Class createInstaceModel() {
        return TransportadoraRedespacho.class;
    }

    @Override
    public BaseForm createInstaceView() {
        return new FormTransRedespacho(this.getAction());
    }

    @Override
    public Object beanModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void beanForm(BaseForm view, Object model) {

    }
    
}
