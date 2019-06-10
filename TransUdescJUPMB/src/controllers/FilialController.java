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
            if (!formConcreto.getTextFieldID().getText().isEmpty()) {
                filial.setId(Integer.parseInt(formConcreto.getTextFieldID().getText()));
            }
            filial.setNome(formConcreto.getTextFieldNome().getText());
            EnderecoController enderecoController = new EnderecoController();
            Endereco endereco = (Endereco) enderecoController.findById(Integer.parseInt(formConcreto.getComboBoxEndereco().getSelectedItem().toString()));
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
            formConcreto.getTextFieldID().setText(Integer.toString(modelConcreto.getId()));
            formConcreto.getTextFieldNome().setText(modelConcreto.getNome());
            formConcreto.getComboBoxEndereco().setSelectedItem(modelConcreto.getEndereco().getId());
            formConcreto.repaint();
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }

}
