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
            if (!formConcreto.getInputId().getValue().isEmpty()) {
                endereco.setId(Integer.parseInt(formConcreto.getInputId().getValue()));
            }
            endereco.setBairro(formConcreto.getInputBairro().getValue());
            endereco.setCep(Integer.parseInt(formConcreto.getInputCEP().getValue()));
            endereco.setCidade(formConcreto.getInputCidade().getValue());
            endereco.setNumero(Integer.parseInt(formConcreto.getInputNumero().getValue()));
            endereco.setPais(formConcreto.getInputPais().getValue());
            endereco.setRua(formConcreto.getInputRua().getValue());
            endereco.setUf(formConcreto.getInputEstado().getValue());
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
            formConcreto.getInputId().setValue(Integer.toString(modelConcreto.getId()));
            formConcreto.getInputBairro().setValue(modelConcreto.getBairro());
            formConcreto.getInputCEP().setValue(Integer.toString(modelConcreto.getCep()));
            formConcreto.getInputCidade().setValue(modelConcreto.getCidade());
            formConcreto.getInputNumero().setValue(Integer.toString(modelConcreto.getNumero()));
            formConcreto.getInputPais().setValue(modelConcreto.getPais());
            formConcreto.getInputRua().setValue(modelConcreto.getRua());
            formConcreto.getInputEstado().setValue(modelConcreto.getUf());
            formConcreto.repaint();
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }
    
}
