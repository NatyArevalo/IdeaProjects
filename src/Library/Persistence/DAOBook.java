package Library.Persistence;

import Library.Entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class DAOBook {
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
    public void save(Book book){
        connect();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        disconnect();
    }
    public void delete(Book book){
        connect();
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
        disconnect();
    }
    public void edit(Book book){
        connect();
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
        disconnect();
    }
    public List<Book> listOfAllBooks(){
        connect();
        List<Book> books = em.createQuery(
                "SELECT a FROM Book a").getResultList();
        disconnect();
        return books;
    }
    public Book searchBookByISBN(Long ISBN){
        connect();
        Book book = (Book) em.createQuery(
                "SELECT a FROM Book a WHERE a.ISBN = " + ISBN).setParameter(1, ISBN).getSingleResult();
        disconnect();
        return book;
    }
    public Book searchBookByTitle(String title){
        connect();
        Book book = (Book) em.createQuery(
                "SELECT a FROM Book a WHERE a.title LIKE : title").setParameter("title", title).getSingleResult();
        disconnect();
        return book;
    }
    public ArrayList<Book> searchBookByAuthorName(String name){
        connect();
        ArrayList<Book> books = (ArrayList<Book>) em.createQuery(
                "SELECT a FROM Book a JOIN a.author b WHERE b.name LIKE : name").setParameter("name", name).getResultList();
        disconnect();
        return books;
    }
    public ArrayList<Book> searchBookByPublisherName(String name){
        connect();
        ArrayList<Book> books = (ArrayList<Book>) em.createQuery(
                "SELECT a FROM Book a JOIN a.publisher b WHERE b.name LIKE : name").setParameter("name", name).getResultList();
        disconnect();
        return books;
    }

}
