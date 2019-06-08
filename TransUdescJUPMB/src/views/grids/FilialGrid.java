/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.grids;

import JUMMP.controllers.BaseController;
import JUMMP.grids.AbstractGrid;
import controllers.FilialController;
import java.util.List;
import models.Filial;

/**
 *
 * @author André Cristen
 */
public class FilialGrid extends AbstractGrid{

    public FilialGrid() {
        super(new FilialController());
    }

    @Override
    public String[] getColunas() {
        String[] colunasFiliais = new String[]{"#", "Endereço", "Nome"};  
        return colunasFiliais;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Filial filial = (Filial)super.getLinhas().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return filial.getId();
            case 1:
                return filial.getEndereco().getId();
            case 2:
                return filial.getNome();
            default:
                return null;
        }
    }
    
}
