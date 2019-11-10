/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.grids;

import JUMMP.controllers.BaseController;
import JUMMP.grids.AbstractGrid;
import controllers.TransportadoraRedespachoController;
import models.TransportadoraRedespacho;

/**
 *
 * @author Lucas Dolsan
 */
public class TransportadoraRedespachoGrid extends AbstractGrid{

    
    
    public TransportadoraRedespachoGrid() {
        super(new TransportadoraRedespachoController());
    }

    @Override
    public String[] getColunas() {
        String[] colunasTransRedespacho = new String[]{"#", "Pessoa Jurídica"};   
        return colunasTransRedespacho;
    }
    
    
    @Override
    public Object getValueRowColumn(int rowIndex, int columnIndex) {
      TransportadoraRedespacho transRedespacho = (TransportadoraRedespacho)super.getLinhas().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return transRedespacho.getId();
            case 1:
                return transRedespacho.getPessoaJuridica().getId();
            default:
                return null;
        }
    }
    
}
