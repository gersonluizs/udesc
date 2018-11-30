/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.control.dao.core;

import br.udesc.ceavi.estude.model.Agenda;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Dell
 */
public class AgendaDAO extends JPADAO<Agenda> {

   

    public List<Agenda> buscarAgenda() {
        List<Agenda> itens = null;
        Query query = em.createNamedQuery("buscarAgenda", Agenda.class);
        itens = query.getResultList();
        return itens;
    }
}
    

