/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.projetolpooe2_malek_rj.dao;


import br.edu.ifsul.cc.lpoo.projetolpooe2_malek_rj.model.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author vanessalagomachado
 */
public class PersistenciaJPA implements InterfacePersistencia {

    EntityManager entity;
    EntityManagerFactory factory;

    public PersistenciaJPA() {
        factory = Persistence.createEntityManagerFactory("pu_restaurante");
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        entity.close();
        if (entity != null && entity.isOpen()) {
            entity.close();
        }
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        return entity.find(c, id);
    }

    @Override
    public void persist(Object o) throws Exception {
        entity.getTransaction().begin();
        entity.persist(o);
        entity.getTransaction().commit();
    }

    /*
    Todos os métodos agora chamam getEntityManager() para garantir que o EntityManager esteja sempre aberto e pronto para uso.
     */
    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    @Override
    public void remover(Object o) throws Exception {
        //No método remover, antes de chamar remove, usamos merge se o objeto não estiver gerenciado.
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            if (!em.contains(o)) {
                o = em.merge(o); // Anexa o objeto ao contexto de persistência, se necessário
            }
            em.remove(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }
    
    public List<Pedido> getPedidos() throws Exception {
        //String jpql = "SELECT descricao FROM Modalidade";  // Nome da entidade 'Modalidade'
        //Query<Modalidade> query = entity.createQuery(jpql);
        //return query.getResultList();

        List<Pedido> pedidos = null;

        pedidos = entity.createQuery("select p from Pedido p", Pedido.class).getResultList();

        return pedidos;
    }
    
    /*
    public List<Alimento> getAlimentosById(String texto) throws Exception {

        try{
            TypedQuery<Modalidade> query = entity.createQuery("SELECT p FROM pro m WHERE LOWER(m.descricao) LIKE :descricao", Modalidade.class);
            query.setParameter("descricao", "%" + texto.toLowerCase() + "%");
            return query.getResultList();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }*/
    
    public List<Alimento> getAlimentos() throws Exception{
        try{
            return entity.createQuery("select a from Alimento a", Alimento.class).getResultList();
        }
        catch(Exception e)
        {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    

}
