package farmacia.controller;

import farmacia.model.Model;
import java.util.ArrayList;

/**
 *
 * @author rogerio
 */
public class Controller {
    
    private Model model;
    private Integer imagenId;
    private float precoRemedio;
    private String nomeRemedio;
    
    public Controller(Model model){
        
        this.model = model;
        
    }
    
    public String retornaDescricao(String nomeRemedio){
        
        String descricaoRemedio = "";
        
        model.fazPesquisa(nomeRemedio);
        
        ArrayList arrayRemedio = model.getArrayBusca();
        
        this.imagenId = (int) arrayRemedio.get(0);
        this.imagenId -=1;
        
        this.precoRemedio = (float) arrayRemedio.get(4);
        this.nomeRemedio = arrayRemedio.get(1).toString();
       
        descricaoRemedio = "<html>Nome: " + arrayRemedio.get(1).toString() +
                "<br><br>Preço: R$" + arrayRemedio.get(4).toString() +
                "<br><br>Quantidade: " + arrayRemedio.get(3).toString() +
                "<br><br><br>bula:<br>" + arrayRemedio.get(2).toString();
        
        return descricaoRemedio;
        
    }
    
    public String nomeImagem(){
        
        return this.imagenId.toString() + ".png";
    }
    
    public String getNome(){
        return this.nomeRemedio;
    }
    
    public float getPreco(){
        
        return this.precoRemedio;
        
    }
    
}
