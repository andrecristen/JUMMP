/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import models.Pessoa;
import JUMMP.forms.BaseForm;
import JUMMP.utils.EventMessage;
import views.forms.FormPessoa;

/**
 *
 * @author André Cristen
 */
public class PessoaController extends BaseController {    
    

    @Override
    public Class createInstaceModel() {
        return Pessoa.class;
    }

    @Override
    public BaseForm createInstaceView() {
        return new FormPessoa(this.getAction());
    }

    @Override
    public Object beanModel() {
        try {
            Pessoa pessoa = new Pessoa();
            FormPessoa formConcreto = (FormPessoa) parameters;
            if (!formConcreto.getTextFieldID().getText().isEmpty()) {
                pessoa.setId(Integer.parseInt(formConcreto.getTextFieldID().getText()));
            }
            pessoa.setNome(formConcreto.getTextFieldNome().getText());
            return pessoa;
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
        return null;
    }

    @Override
    public void beanForm(BaseForm view, Object model) {
        try {
            FormPessoa formConcreto = (FormPessoa) view;
            Pessoa modelConcreto = (Pessoa) model;
            formConcreto.getTextFieldID().setText(Integer.toString(modelConcreto.getId()));
            formConcreto.getTextFieldNome().setText(modelConcreto.getNome());
            formConcreto.repaint();
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }
}
