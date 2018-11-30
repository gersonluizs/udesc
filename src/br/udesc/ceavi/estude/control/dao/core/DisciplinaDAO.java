/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.control.dao.core;

import br.udesc.ceavi.estude.model.Disciplina;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Dell
 */
public class DisciplinaDAO extends JPADAO<Disciplina> {

    public List<Disciplina> buscarDisciplina() {
        List<Disciplina> itens = null;
        Query query = em.createNamedQuery("buscarCidade", Disciplina.class);
        itens = query.getResultList();
        return itens;
    }
}
