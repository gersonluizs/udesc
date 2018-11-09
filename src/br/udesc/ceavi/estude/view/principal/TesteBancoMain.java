package br.udesc.ceavi.estude.view.principal;


import br.udesc.ceavi.estude.control.dao.core.DAO;
import br.udesc.ceavi.estude.control.dao.core.JPADAO;

/**
 * Esta classe define o fonte de teste para JPA 
 * @author Márcio José Mantau   
 * @version 1.0
 * @since 14/05/2018
 */
public class TesteBancoMain {
   
    public static void main(String args[]){
    
        
       //Instancia o JPADAO e insere no banco os objetos
       DAO dao = new JPADAO();
        
    }
}
