package br.udesc.ceavi.estude.view.principal;

import br.udesc.ceavi.estude.control.dao.core.DAO;
import br.udesc.ceavi.estude.control.dao.core.JPADAO;

/**
 * Esta classe define o fonte de teste para JPA
 *
 * @author Gerson, Lucas e Matheus
 * @version 1.0
 *
 */
public class TesteBancoMain {

    public static void main(String args[]) {

        //Instancia o JPADAO e insere no banco os objetos
        DAO dao = new JPADAO();

    }
}
