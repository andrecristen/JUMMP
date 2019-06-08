/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import models.Veiculo;
import JUMMP.forms.BaseForm;
import views.forms.FormVeiculo;

/**
 *
 * @author André Cristen
 */
public class VeiculoController extends BaseController {
    
    @Override
    public Class createInstaceModel() {
        return Veiculo.class;
    }

    @Override
    public BaseForm createInstaceView() {
        return new FormVeiculo(this.getAction());
    }

    @Override
    public Object beanModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void beanForm(BaseForm view, Object model) {

    }
    

}
