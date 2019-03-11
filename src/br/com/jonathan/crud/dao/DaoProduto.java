package br.com.jonathan.crud.dao;

import br.com.jonathan.crud.model.Produto;
import br.com.jonathan.crud.services.Manager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author jonathan.medeiros
 */
public class DaoProduto {
    
    private EntityManager em;

    public DaoProduto() {
        em = Manager.getInstance().getEm();
    }      
    
    public void salvar(Produto p) {
        em.getTransaction().begin();
        
        if (p.getId() > 0) {
            p = em.merge(p);
        }
        
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public List<Produto> getAll() {
        Query query = em.createQuery("From ".concat(Produto.class.getName()));
        return (List<Produto>) query.getResultList();        
    }
    
    public void remover(Produto p) {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }
    
}
