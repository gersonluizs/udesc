/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.control.dao.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Dell
 */
public class JPADAO<X> implements DAO {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public JPADAO() {
        super();
        emf = javax.persistence.Persistence.
                createEntityManagerFactory("ProjetoPratico");
        em = emf.createEntityManager();
    }

    @Override
    public boolean inserir(Object obj) throws Exception {
        em.getTransaction().begin();
        try {
            em.persist(obj);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }

        return false;
    }

    @Override
    public boolean atualizar(Object obj) throws Exception {
        em.getTransaction().begin();
        try {
            em.merge(obj);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }

        return false;
    }

    @Override
    public boolean deletar(Object obj) throws Exception {
        em.getTransaction().begin();
        try {
            em.remove(obj);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }

        return false;
    }

    @Override
    public Object pesquisarPorId(Class tipo, long id) throws Exception {
        Object object = null;
        em.getTransaction().begin();

        try {
            object = em.find(tipo, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        return object;
    }

}
