package Library.Persistence;

import Library.Entities.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class DAOAuthor {
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
    public void save(Author author){
        connect();
        em.getTransaction().begin();
        em.persist(author);
        em.getTransaction().commit();
        disconnect();
    }
    public void delete(Author author){
        connect();
        em.getTransaction().begin();
        em.remove(author);
        em.getTransaction().commit();
        disconnect();
    }
    public void edit(Author author){
        connect();
        em.getTransaction().begin();
        em.merge(author);
        em.getTransaction().commit();
        disconnect();
    }
    public Author searchAuthorByName(String name) throws Exception{
        connect();
        Author author = (Author) em.createQuery("SELECT a FROM Author a WHERE a.name LIKE :name").setParameter("name", name).getSingleResult();
        disconnect();
        return author;
    }

}
