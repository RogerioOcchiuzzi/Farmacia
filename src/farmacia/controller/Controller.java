package farmacia.controller;

import farmacia.model.Model;
import java.util.ArrayList;

/**
 *
 * @author rogerio
 */
public class Controller {
    
    private Model model;
    private String imagenId;
    
    public Controller(Model model){
        
        this.model = model;
        
    }
    
    public String retornaDescricao(String nomeRemedio){
        
        String descricaoRemedio = "";
        
        model.fazPesquisa(nomeRemedio);
        
        ArrayList arrayRemedio = model.getArrayBusca();
        
        this.imagenId = arrayRemedio.get(0).toString();
       
        descricaoRemedio = "<html>Nome: " +arrayRemedio.get(1).toString() +
                "<br><br>Preço: R$" +arrayRemedio.get(4).toString() +
                "<br><br>Quantidade: " +arrayRemedio.get(3).toString() +
                "<br><br><br>bula:<br>" +arrayRemedio.get(2).toString();
        
        return descricaoRemedio;
        
    }
    
    public String nomeImagem(){
        
        return this.imagenId + ".png";
    }
    
}
