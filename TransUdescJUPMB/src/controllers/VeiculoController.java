/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import models.Veiculo;
import JUMMP.forms.BaseForm;
import JUMMP.utils.EventMessage;
import java.util.Date;
import models.StatusVeiculo;
import models.TipoVeiculo;
import views.forms.FormVeiculo;

/**
 *
 * @author André Cristen
 */
public class VeiculoController extends BaseController {

    @Override
    public Class createInstaceModel() {
        return Veiculo.class;
    }

    @Override
    public BaseForm createInstaceView() {
        return new FormVeiculo(this.getAction());
    }

    @Override
    public Object beanModel() {
        try {
            Veiculo veiculo = new Veiculo();
            FormVeiculo formVeiculo = (FormVeiculo) parameters;
            if (!formVeiculo.getTextFieldID().getText().isEmpty()) {
                veiculo.setId(Integer.parseInt(formVeiculo.getTextFieldID().getText()));
            }
            veiculo.setDataAquisicao(new Date(formVeiculo.getTextFieldDataAquisicao().getText()));
            veiculo.setPlaca(formVeiculo.getTextFieldPlaca().getText());
            veiculo.setStatus(StatusVeiculo.fromString(formVeiculo.getComboBoxStatus().getSelectedItem().toString()));
            veiculo.setTipo(TipoVeiculo.fromString(formVeiculo.getComboBoxTipo().getSelectedItem().toString()));
            return veiculo;
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
        return null;
    }

    @Override
    public void beanForm(BaseForm view, Object model) {
        try {
            FormVeiculo formVeiculo = (FormVeiculo) view;
            Veiculo modelVeiculo = (Veiculo) model;
            formVeiculo.getTextFieldID().setText(Integer.toString(modelVeiculo.getId()));
            formVeiculo.getTextFieldDataAquisicao().setText(modelVeiculo.getDataAquisicao().toString());
            formVeiculo.getTextFieldPlaca().setText(modelVeiculo.getPlaca());
            formVeiculo.getComboBoxStatus().setSelectedItem(modelVeiculo.getStatus());
            formVeiculo.getComboBoxTipo().setSelectedItem(modelVeiculo.getTipo());
            formVeiculo.repaint();
        } catch (Exception e) {
            new EventMessage(e.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }

}