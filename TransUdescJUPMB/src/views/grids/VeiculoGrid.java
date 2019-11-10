/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.grids;

import JUMMP.controllers.BaseController;
import JUMMP.grids.AbstractGrid;
import controllers.VeiculoController;
import java.util.List;
import models.Veiculo;

/**
 *
 * @author André Cristen
 */
public class VeiculoGrid extends AbstractGrid{

    public VeiculoGrid() {
        super(new VeiculoController());
    }

    @Override
    public String[] getColunas() {
        String[] colunasVeiculos = new String[]{"#", "Aquisição", "Placa", "Status", "Tipo"};  
        return colunasVeiculos;
    }
    
    

    @Override
    public Object getValueRowColumn(int rowIndex, int columnIndex) {
      Veiculo veiculo = (Veiculo)super.getLinhas().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return veiculo.getId();
            case 1:
                return veiculo.getDataAquisicao();
            case 2:
                return veiculo.getPlaca();
            case 3:
                return veiculo.getStatus();
            case 4:
                return veiculo.getTipo();
            default:
                return null;
        }
    }
    
}
