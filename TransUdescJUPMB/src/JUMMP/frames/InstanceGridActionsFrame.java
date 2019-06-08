/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUMMP.frames;

import java.util.List;
import JUMMP.utils.Action;
import JUMMP.grids.AbstractGrid;

/**
 *
 * @author André Cristen
 * Deve ser usado para intancia de novos frames em aberturas de telas
 * que contenham Grids internos e contem as acoes para modelo.
 * 
 * As ações devem ser passadas como um array list do modelo JUMPB.utils.Action
 */
public class InstanceGridActionsFrame extends AbstractGridFrameActions{
    
    public InstanceGridActionsFrame(String title, AbstractGrid tableAppend, List<Action> actions) {
        super(title, tableAppend, actions);
    }
    
}
