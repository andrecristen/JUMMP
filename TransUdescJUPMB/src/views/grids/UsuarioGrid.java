/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.grids;

import JUMMP.grids.AbstractGrid;
import controllers.UsuarioController;
import models.Usuario;

/**
 *
 * @author Lucas Levi Gonçalves
 */
public class UsuarioGrid extends AbstractGrid{

    public UsuarioGrid() {
        super(new UsuarioController());
    }

    @Override
    public String[] getColunas() {
         String[] colunasUsuarios = new String[]{"#", "Pessoa", "Login"};
         return colunasUsuarios;
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Usuario volume = (Usuario)super.getLinhas().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return volume.getId();
            case 1:
                return volume.getPessoa().getNome();
            case 2:
                return volume.getLogin();
            default:
                return null;
                        }
    }
    
}
