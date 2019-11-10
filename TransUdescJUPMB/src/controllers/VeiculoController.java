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
            if (!formVeiculo.getInputID().getValue().isEmpty()) {
                veiculo.setId(Integer.parseInt(formVeiculo.getInputID().getValue()));
            }
            veiculo.setDataAquisicao(formVeiculo.getInputDataAquisicao().getValue());
            veiculo.setPlaca(formVeiculo.getInputPlaca().getValue());
            veiculo.setStatus(StatusVeiculo.fromString(formVeiculo.getSelectStatus().getValue()));
            veiculo.setTipo(TipoVeiculo.fromString(formVeiculo.getSelectTipo().getValue()));
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
            formVeiculo.getInputID().setValue(Integer.toString(modelVeiculo.getId()));
            formVeiculo.getInputDataAquisicao().setValue(modelVeiculo.getDataAquisicao());
            formVeiculo.getInputPlaca().setValue(modelVeiculo.getPlaca());
            formVeiculo.getSelectStatus().setValue(modelVeiculo.getStatus());
            formVeiculo.getSelectTipo().setValue(modelVeiculo.getTipo());
            formVeiculo.repaint();
        } catch (Exception e) {
            new EventMessage(e.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }

}