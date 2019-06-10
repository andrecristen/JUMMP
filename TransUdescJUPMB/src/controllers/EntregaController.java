/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import models.Entrega;
import JUMMP.forms.BaseForm;
import JUMMP.utils.EventMessage;
import models.Endereco;
import models.SituacaoEntrega;
import models.TransportadoraRedespacho;
import models.Volume;
import views.forms.FormEntrega;

/**
 *
 * @author André Cristen
 */
public class EntregaController extends BaseController {

    @Override
    public Class createInstaceModel() {
        return Entrega.class;
    }

    @Override
    public BaseForm createInstaceView() {
        return new FormEntrega(this.getAction());
    }

    @Override
    public Object beanModel() {
        try {
            Entrega entrega = new Entrega();
            FormEntrega formEntrega = (FormEntrega) parameters;
            if (!formEntrega.getTextFieldID().getText().isEmpty()) {
                entrega.setId(Integer.parseInt(formEntrega.getTextFieldID().getText()));
            }
            entrega.setSituacao(Integer.parseInt(formEntrega.getComboBoxSituacao().getSelectedItem().toString()));
            EnderecoController enderecoController = new EnderecoController();
            Endereco endereco = (Endereco) enderecoController.findById(Integer.parseInt(formEntrega.getComboBoxEnderecoDestino().getSelectedItem().toString()));
            entrega.setEnderecoDestino(endereco);
            TransportadoraRedespachoController transportadoraRedespachoController = new TransportadoraRedespachoController();
            TransportadoraRedespacho transportadoraRedespacho = (TransportadoraRedespacho) transportadoraRedespachoController.findById(Integer.parseInt(formEntrega.getComboBoxRedespacho().getSelectedItem().toString()));
            entrega.setRedespacho(transportadoraRedespacho);

            //tabela de volumes
            
            return null;
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
        return null;
    }

    @Override
    public void beanForm(BaseForm view, Object model) {
 FormEntrega formEntrega = (FormEntrega) view;
           Entrega modelEntrega = (Entrega) model;
           formEntrega.getTextFieldID().setText(Integer.toString(modelEntrega.getId()));
           formEntrega.getComboBoxEnderecoDestino().setSelectedItem(modelEntrega.getEnderecoDestino().getId());
           formEntrega.getComboBoxRedespacho().setSelectedItem(modelEntrega.getRedespacho().getId());
           formEntrega.getComboBoxSituacao().setSelectedItem(modelEntrega.getSituacao());
           
           //fazer tabela de volumes
           
           formEntrega.repaint();
    }
}
