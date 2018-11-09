/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.control.dao.core;

/**
 *
 * @author Dell
 */
public interface DAO<X> {

    boolean inserir(X obj) throws Exception;

    boolean atualizar(X obj) throws Exception;

    boolean deletar(X obj) throws Exception;

    public Object pesquisarPorId(Class tipo, long id) throws Exception;

}
