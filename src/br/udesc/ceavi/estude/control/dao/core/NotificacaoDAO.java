/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.control.dao.core;

import br.udesc.ceavi.estude.model.Notificacao;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Dell
 */
public class NotificacaoDAO extends JPADAO<Notificacao> {

    public List<Notificacao> buscarNotificacao() {
        List<Notificacao> itens = null;
        Query query = em.createNamedQuery("buscarNotificacao", Notificacao.class);
        itens = query.getResultList();
        return itens;
    }
}
