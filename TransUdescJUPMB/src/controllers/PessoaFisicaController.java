/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import JUMMP.forms.BaseForm;
import JUMMP.utils.EventMessage;
import models.PessoaFisica;
import views.forms.FormPessoaFisica;

/**
 *
 * @author André Cristen
 */
public class PessoaFisicaController extends BaseController {    
    

    @Override
    public Class createInstaceModel() {
        return PessoaFisica.class;
    }

    @Override
    public BaseForm createInstaceView() {
        return new FormPessoaFisica(this.getAction());
    }

    @Override
    public Object beanModel() {
        try {
            PessoaFisica pessoa = new PessoaFisica();
            FormPessoaFisica formConcreto = (FormPessoaFisica) parameters;
            return pessoa;
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
        return null;
    }

    @Override
    public void beanForm(BaseForm view, Object model) {
        try {
            FormPessoaFisica formConcreto = (FormPessoaFisica) view;
            PessoaFisica modelConcreto = (PessoaFisica) model;
            formConcreto.repaint();
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }
}
