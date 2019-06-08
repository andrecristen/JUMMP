/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUMMP.models;

/**
 *
 * @author Andre Cristen
 * 
 * Com base em conhecimentos de outros frames resolvemos dar como padrao que 
 * todos nosso modelos devem possui um getId.
 */
public abstract class AbstractModel {
    
    public abstract int getId();

    public abstract void setId(int id);
}
