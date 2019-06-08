/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import java.util.List;
import models.Endereco;
import JUMMP.forms.BaseForm;
import views.forms.FormEndereco;

/**
 *
 * @author André Cristen
 */
public class EnderecoController extends BaseController {

    @Override
    public Class createInstaceModel() {
        return Endereco.class;
    }

    @Override
    public BaseForm createInstaceView() {
        return new FormEndereco(this.getAction());
    }

    @Override
    public Object beanModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void beanForm(BaseForm view, Object model) {

    }
    
}
