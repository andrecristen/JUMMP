/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.grids;

import JUMMP.controllers.BaseController;
import JUMMP.grids.AbstractGrid;
import controllers.CarregamentoController;
import java.util.List;
import models.Carregamento;
import models.Veiculo;

/**
 *
 * @author André Cristen
 */
public class CarregamentoGrid extends AbstractGrid{

    public CarregamentoGrid() {
        super(new CarregamentoController());
    }

    @Override
    public String[] getColunas() {
       String[] colunasCarregamentos = new String[]{"#", "Endereço chegada", "Endereço saída"};
       return colunasCarregamentos;
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Carregamento carregamento = (Carregamento)super.getLinhas().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return carregamento.getId();
            case 1:
                return carregamento.getEnderecoChegada();
            case 2:
                return carregamento.getEnderecoSaida();
            default:
                return null;
        }
    }
    
}
