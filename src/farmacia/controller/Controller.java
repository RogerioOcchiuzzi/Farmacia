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
    private int quantidadeItem;
    
    public Controller(Model model){
        
        this.model = model;
        
    }
    
    public ArrayList retornaDescricao(String nomeRemedio){
        
        String descricaoRemedio = "";
        
        model.fazPesquisa(nomeRemedio);
        
        ArrayList arrayRemedio = model.getArrayBusca();
        
        this.imagenId = (int) arrayRemedio.get(0);
        this.imagenId -=1;
        
        this.precoRemedio = (float) arrayRemedio.get(4);
        this.nomeRemedio = arrayRemedio.get(1).toString();
        this.quantidadeItem = (int) arrayRemedio.get(3);      
        
        return arrayRemedio;
        
    }
    
    public void mudaQuantidadeEstoque(int quantidade, String nomeItem){
        
        this.model.mudaQuantidade(quantidade, nomeItem);
        
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
