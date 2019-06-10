/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import JUMMP.forms.BaseForm;
import JUMMP.utils.EventMessage;
import models.PessoaJuridica;
import views.forms.FormPessoaJuridica;

/**
 *
 * @author André Cristen
 */
public class PessoaJuridicaController extends BaseController {    
    

    @Override
    public Class createInstaceModel() {
        return PessoaJuridica.class;
    }

    @Override
    public BaseForm createInstaceView() {
        return new FormPessoaJuridica(this.getAction());
    }

    @Override
    public Object beanModel() {
        try {
            PessoaJuridica pessoa = new PessoaJuridica();
            FormPessoaJuridica formConcreto = (FormPessoaJuridica) parameters;
            return pessoa;
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
        return null;
    }

    @Override
    public void beanForm(BaseForm view, Object model) {
        try {
            FormPessoaJuridica formConcreto = (FormPessoaJuridica) view;
            PessoaJuridica modelConcreto = (PessoaJuridica) model;
            formConcreto.repaint();
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }
}
