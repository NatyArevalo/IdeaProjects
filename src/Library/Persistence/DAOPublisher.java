package Library.Persistence;

import Library.Entities.Publisher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DAOPublisher {
    private final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("JPAPU");
    private EntityManager em = EMF.createEntityManager();
    public void connect(){
        if(!em.isOpen()){
            em = EMF.createEntityManager();
        }
    }
    public void disconnect(){
        if(em.isOpen()){
            em.close();
        }
    }
    public void save(Publisher publisher){
        connect();
        em.getTransaction().begin();
        em.persist(publisher);
        em.getTransaction().commit();
        disconnect();
    }
    public void delete(Publisher publisher){
        connect();
        em.getTransaction().begin();
        em.remove(publisher);
        em.getTransaction().commit();
        disconnect();
    }
    public void edit(Publisher publisher){
        connect();
        em.getTransaction().begin();
        em.merge(publisher);
        em.getTransaction().commit();
        disconnect();
    }
    public Publisher searchPublisherByName(String name) throws Exception{
        connect();
        Publisher publisher = (Publisher) em.createQuery("SELECT a FROM Publisher a WHERE a.name LIKE :name").setParameter("name", name).getSingleResult();
        disconnect();
        return publisher;
    }
}
