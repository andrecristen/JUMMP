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
import JUMMP.utils.EventMessage;
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
     try {
            Endereco endereco = new Endereco();
            FormEndereco formConcreto = (FormEndereco) parameters;
            if (!formConcreto.getTextFieldID().getText().isEmpty()) {
                endereco.setId(Integer.parseInt(formConcreto.getTextFieldID().getText()));
            }
            endereco.setBairro(formConcreto.getTextFieldBairro().getText());
            endereco.setCep(Integer.parseInt(formConcreto.getTextFieldCEP().getText()));
            endereco.setCidade(formConcreto.getTextFieldCidade().getText());
            endereco.setNumero(Integer.parseInt(formConcreto.getTextFieldNumero().getText()));
            endereco.setPais(formConcreto.getTextFieldPais().getText());
            endereco.setRua(formConcreto.getTextFieldRua().getText());
            endereco.setUf(formConcreto.getTextFieldEstado().getText());
            return endereco;
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
        return null;
    }
    @Override
    public void beanForm(BaseForm view, Object model) {
         try {
            FormEndereco formConcreto = (FormEndereco) view;
            Endereco modelConcreto = (Endereco) model;
            formConcreto.getTextFieldID().setText(Integer.toString(modelConcreto.getId()));
            formConcreto.getTextFieldBairro().setText(modelConcreto.getBairro());
            formConcreto.getTextFieldCEP().setText(Integer.toString(modelConcreto.getCep()));
            formConcreto.getTextFieldCidade().setText(modelConcreto.getCidade());
            formConcreto.getTextFieldNumero().setText(Integer.toString(modelConcreto.getNumero()));
            formConcreto.getTextFieldPais().setText(modelConcreto.getPais());
            formConcreto.getTextFieldRua().setText(modelConcreto.getRua());
            formConcreto.getTextFieldEstado().setText(modelConcreto.getUf());
            formConcreto.repaint();
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }
    
}
