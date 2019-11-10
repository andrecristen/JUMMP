/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.grids;

import JUMMP.grids.AbstractGrid;
import controllers.PessoaFisicaController;
import controllers.PessoaJuridicaController;
import models.PessoaJuridica;

/**
 *
 * @author André Cristen
 */
public class PessoaJuridicaGrid extends AbstractGrid{

    public PessoaJuridicaGrid() {
        super(new PessoaJuridicaController());
    }

    @Override
    public String[] getColunas() {
        String[] colunasPessoas = new String[]{"#", "CNPJ"};
        return colunasPessoas;
    }

    @Override
    public Object getValueRowColumn(int rowIndex, int columnIndex) {
      PessoaJuridica pessoa = (PessoaJuridica)super.getLinhas().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return pessoa.getId();
            case 1:
                return pessoa.getCnpj();
            default:
                return null;
        }
    }
    
}
