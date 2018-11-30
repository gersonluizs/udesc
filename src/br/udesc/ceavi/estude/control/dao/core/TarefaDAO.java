/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.control.dao.core;

import br.udesc.ceavi.estude.model.Tarefa;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Dell
 */
public class TarefaDAO extends JPADAO<Tarefa> {

    public List<Tarefa> buscarTarefa() {
        List<Tarefa> itens = null;
        Query query = em.createNamedQuery("buscarTarefa", Tarefa.class);
        itens = query.getResultList();
        return itens;
    }
}