/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import JUMMP.controllers.BaseController;
import models.Volume;
import JUMMP.forms.BaseForm;
import JUMMP.utils.EventMessage;
import views.forms.FormVolume;

/**
 * @author Andre Cristen
 */
public class VolumeController extends BaseController {

    @Override
    public Class createInstaceModel() {
        return Volume.class;
    }

    @Override
    public BaseForm createInstaceView() {
        return new FormVolume(this.getAction());
    }

    @Override
    public Object beanModel() {
        try {
            Volume volume = new Volume();
            FormVolume formConcreto = (FormVolume) parameters;
            if (!formConcreto.getTextFieldID().getText().isEmpty()) {
                volume.setId(Integer.parseInt(formConcreto.getTextFieldID().getText()));
            }
            volume.setCubagem(Double.parseDouble(formConcreto.getTextFieldCubagem().getText()));
            volume.setPesoBruto(Float.parseFloat(formConcreto.getTextFieldPesoBruto().getText()));
            volume.setPesoLiquido(Float.parseFloat(formConcreto.getTextFieldPesoLiquido().getText()));
            return volume;
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
        return null;
    }

    public void beanForm(BaseForm view, Object model) {
        try {
            FormVolume formConcreto = (FormVolume) view;
            Volume modelConcreto = (Volume) model;
            formConcreto.getTextFieldID().setText(Integer.toString(modelConcreto.getId()));
            formConcreto.getTextFieldCubagem().setText(Double.toString(modelConcreto.getCubagem()));
            formConcreto.getTextFieldPesoBruto().setText(Double.toString(modelConcreto.getPesoBruto()));
            formConcreto.getTextFieldPesoLiquido().setText(Double.toString(modelConcreto.getPesoLiquido()));
            formConcreto.repaint();
        } catch (Exception exception) {
            new EventMessage(exception.getMessage(), EventMessage.getTIPO_ERRO());
        }
    }

}
