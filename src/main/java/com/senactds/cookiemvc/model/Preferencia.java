
package com.senactds.cookiemvc.model;

/**
 *
 * @author davi_
 */
public class Preferencia {
    
    private String nome;
    private String estilo;
    private String fonte;

    public String getNome() {
        return nome;
    }

    public String getEstilo() {
        return estilo;
    }
    
    public String getFonte(){
        return fonte;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
    
    public void setFonte(String fonte){
        this.fonte = fonte;
    }
}
