/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import models.TrackingEntrega;
import JUMMP.forms.BaseForm;
import views.forms.FormTrackingEntrega;

/**
 *
 * @author André Cristen
 */
public class TrackingEntregaController extends BaseController{

    @Override
    public Class createInstaceModel() {
        return TrackingEntrega.class;
    }

    @Override
    public BaseForm createInstaceView() {
        return new FormTrackingEntrega(this.getAction());
    }

    @Override
    public Object beanModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void beanForm(BaseForm view, Object model) {

    }
}
