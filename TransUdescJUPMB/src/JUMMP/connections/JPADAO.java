package JUMMP.connections;

import JUMMP.utils.EventMessage;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import main.Home;
import models.Usuario;

/**
 * @author Andre Cristen
 */
public class JPADAO<Object> implements DAO<Object> {

    protected static EntityManagerFactory emf;
    protected static EntityManager em;
    
    protected Exception lastException;

    /**
     * Inicia as instancias com base em uma Unidade de Persistencia
     */
    public JPADAO() {
        super();
        //Deve Receber o nome da unidade de persistencia
        emf = javax.persistence.Persistence.createEntityManagerFactory(Home.getPesistenceName());
        em = emf.createEntityManager();
    }

    /**
     * Insere um objeto no banco
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public boolean persist(Object obj) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            this.setLastException(e);
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return false;
    }

    /**
     * Atualiza um objeto no banco
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public boolean update(Object obj) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            this.setLastException(e);
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return false;
    }

    /**
     * Exclui um objeto do banco
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public boolean delete(Object obj) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            this.setLastException(e);
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return false;
    }

    /**
     * Busca um modelo com base no tipo e no id
     *
     * @param tipo
     * @param id
     * @return
     * @throws Exception
     */
    public Object findById(Class tipo, long id) throws Exception {
        Object object = null;
        try {
            em.getTransaction().begin();
            object = (Object) em.find(tipo, (int) (long) id);
            em.getTransaction().commit();
        } catch (Exception e) {
            this.setLastException(e);
            new EventMessage(e.getMessage(), EventMessage.getTIPO_ERRO());
            em.getTransaction().rollback();
        }
        return object;
    }

    /**
     * Busca todos os objetos em banco de um modelo.
     *
     * @param tipo
     * @return
     */
    public List getAll(Class tipo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object> cq = cb.createQuery(tipo);
        TypedQuery<Object> allQuery = em.createQuery(cq);
        List<Object> list = allQuery.getResultList();
        return list;
    }

    public Usuario validarLogin(String login, String senha) {
        Query query = em.createNamedQuery("validarLogin");
        query.setParameter(1, login);
        query.setParameter(2, senha);
        List<Usuario> retorno = query.getResultList();
        if (retorno.isEmpty()) {
            return new Usuario();
        }
        return retorno.get(0);
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void setEmf(EntityManagerFactory emf) {
        JPADAO.emf = emf;
    }

    public static EntityManager getEm() {
        return em;
    }

    public static void setEm(EntityManager em) {
        JPADAO.em = em;
    }

    public Exception getLastException() {
        return lastException;
    }

    public void setLastException(Exception lastException) {
        this.lastException = lastException;
    }

}
