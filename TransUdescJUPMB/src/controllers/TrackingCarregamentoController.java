/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import models.TrackingCarregamento;
import JUMMP.forms.BaseForm;
import views.forms.FormTrakingCarregamento;

/**
 *
 * @author André Cristen
 */
public class TrackingCarregamentoController extends BaseController{

    @Override
    public Class createInstaceModel() {
        return TrackingCarregamento.class;
    }

    @Override
    public BaseForm createInstaceView() {
        return new FormTrakingCarregamento(this.getAction());
    }

    @Override
    public Object beanModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void beanForm(BaseForm view, Object model) {

    }
}
