/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.grids;

import JUMMP.controllers.BaseController;
import JUMMP.grids.AbstractGrid;
import controllers.EnderecoController;
import java.util.ArrayList;
import java.util.List;
import models.Endereco;

/**
 *
 * @author André Cristen
 */
public class EnderecoGrid extends AbstractGrid{

    public EnderecoGrid() {
        super(new EnderecoController());
    }

    @Override
    public String[] getColunas() {
       String[] colunasCarregamentos = new String[]{"#", "Bairro", "CEP", "Cidade"};
       return colunasCarregamentos;
    }
    
    
    
    public Object getValueRowColumn(int rowIndex, int columnIndex) {
        Endereco endereco = (Endereco)super.getLinhas().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return endereco.getId();
            case 1:
                return endereco.getBairro();
            case 2:
                return endereco.getCep();
            case 3:
                return endereco.getCidade();
            default:
                return null;
        }
    }
    
}
