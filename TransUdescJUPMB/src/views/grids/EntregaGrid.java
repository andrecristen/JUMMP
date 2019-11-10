/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.grids;

import JUMMP.controllers.BaseController;
import JUMMP.grids.AbstractGrid;
import controllers.EntregaController;
import models.Entrega;


/**
 *
 * @author André Cristen
 */
public class EntregaGrid extends AbstractGrid{

    public EntregaGrid() {
        super(new EntregaController());
    }

    @Override
    public String[] getColunas() {
        String[] colunasEntregas = new String[]{"#", "Endereco Destino", "Transportadora Redes."};
        return colunasEntregas;
    }

    
    @Override
    public Object getValueRowColumn(int rowIndex, int columnIndex) {
        Entrega entrega = (Entrega)super.getLinhas().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return entrega.getId();
            case 1:
                return entrega.getEnderecoDestino().getId();
            case 2:
                return entrega.getId();
            default:
                return null;
        }
    }
    
}
