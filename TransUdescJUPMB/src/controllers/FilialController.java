/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import models.Filial;
import JUMMP.forms.BaseForm;
import JUMMP.utils.EventMessage;
import models.Endereco;
import views.forms.FormFilial;

/**
 *
 * @author André Cristen
 */
public class FilialController extends BaseController {

    @Override
    public Class createInstaceModel() {
        return Filial.class;
    }

    @Override
    public BaseForm createInstaceView() {
        return new FormFilial(this.getAction());
    }

    public Object beanModel() {
        try {
            Filial filial = new Filial();
            FormFilial formConcreto = (FormFilial) parameters;
            if (!formConcreto.getInputID().getValue().isEmpty()) {
                filial.setId(Integer.parseInt(formConcreto.getInputID().getValue()));
            }
            filial.setNome(formConcreto.getInputNome().getValue());
            EnderecoController enderecoController = new EnderecoController();
            Endereco endereco = (Endereco) enderecoController.findById(Integer.parseInt(formConcreto.getSelectEndereco().getValue()));
            filial.setEndereco(endereco);
            return filial;
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
        return null;
    }

    @Override
    public void beanForm(BaseForm view, Object model) {
        try {
            FormFilial formConcreto = (FormFilial) view;
            Filial modelConcreto = (Filial) model;
            formConcreto.getInputID().setValue(Integer.toString(modelConcreto.getId()));
            formConcreto.getInputNome().setValue(modelConcreto.getNome());
            formConcreto.getSelectEndereco().setValue(modelConcreto.getEndereco().getId());
            formConcreto.repaint();
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }

}
