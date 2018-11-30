/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.control.dao.core;

import br.udesc.ceavi.estude.model.Conteudo;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Dell
 */
public class ConteudoDAO extends JPADAO<Conteudo> {

    public List<Conteudo> buscarConteudo() {
        List<Conteudo> itens = null;
        Query query = em.createNamedQuery("buscarConteudo", Conteudo.class);
        itens = query.getResultList();
        return itens;
    }
}