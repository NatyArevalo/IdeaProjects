package Library.Services;

import Library.Entities.Author;
import Library.Entities.Book;
import Library.Entities.Publisher;
import Library.Persistence.DAOBook;

import java.util.ArrayList;
import java.util.List;

public class BookServices {
    private AuthorServices authorServices;
    private PublisherServices publisherServices;
    private final DAOBook DAO;

    public BookServices() {
        this.DAO = new DAOBook();
    }

    public void setServices(AuthorServices authorServices, PublisherServices publisherServices) {
        this.authorServices = authorServices;
        this.publisherServices = publisherServices;
    }

    public Book createBook(Long ISBN, String title, Integer anio, Integer copies, Integer borrowedCopies, Integer remainingCopies, Author author, Publisher publisher){
        Book book = new Book();
        try{
            if(ISBN<=0){
                throw new Exception("ISBN must be valid");
            }
            if(title == null || title.trim().isEmpty()){
                throw new Exception("Title cannot be empty");
            }
            if(anio<=0){
                throw new Exception("Año must be valid");
            }
            if(copies<=0){
                throw new Exception("Number of copies must be valid");
            }
            if(borrowedCopies<0){
                throw new Exception("Number of borrowed copies must be valid");
            }
            if(remainingCopies<0){
                throw new Exception("Number of remaining copies must be valid");
            }
            if(author == null){
                throw new Exception("Author needs to be valid");
            }
            if(publisher == null){
                throw new Exception("Publisher needs to be valid");
            }
            book.setISBN(ISBN);
            book.setTitle(title);
            book.setAnio(anio);
            book.setCopies(copies);
            book.setBorrowedCopies(borrowedCopies);
            book.setRemainingCopies(remainingCopies);
            book.setAuthor(author);
            book.setPublisher(publisher);
            DAO.save(book);
            return book;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Book modifyBookByTitle(String title,Integer copies, Integer borrowedCopies, Integer remainingCopies, Boolean active ){
        try{
            if(copies<=0){
                throw new Exception("Number of copies must be valid");
            }
            if(borrowedCopies<0){
                throw new Exception("Number of borrowed copies must be valid");
            }
            if(remainingCopies<0){
                throw new Exception("Number of remaining copies must be valid");
            }
            Book book = searchBookByTitle(title);
            book.setCopies(copies);
            book.setBorrowedCopies(borrowedCopies);
            book.setRemainingCopies(remainingCopies);
            book.setActive(active);
            DAO.edit(book);
            return book;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void deleteBookByISBN(Long ISBN){
        try{
            if(ISBN<=0){
                throw new Exception("ISBN must be valid");
            }
            Book book = searchBookByISBN(ISBN);
            DAO.delete(book);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public List<Book> showAllBooks(){
        try{
            List<Book> books = DAO.listOfAllBooks();
            if (books.isEmpty()){
                throw new Exception("No books have been added");
            }
            return books;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Book searchBookByISBN(Long ISBN){
        try{
            if(ISBN<=0){
                throw new Exception("ISBN must be valid");
            }
            Book book = DAO.searchBookByISBN(ISBN);
            if(book == null){
                throw new Exception("No book was found with this criteria");
            }
            return book;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Book searchBookByTitle(String title){
        try{
            if(title == null || title.trim().isEmpty()){
                throw new Exception("Title cannot be empty");
            }
            Book book = DAO.searchBookByTitle(title);
            if(book == null){
                throw new Exception("No book was found with this criteria");
            }
            return book;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public ArrayList<Book> searchBookByAuthor(String name){
        try{
            if(name == null || name.trim().isEmpty()){
                throw new Exception("Name cannot be empty");
            }
            ArrayList<Book> books = DAO.searchBookByAuthorName(name);
            if (books == null){
                throw new Exception("No book was found with this criteria");
            }
            return books;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public ArrayList<Book> searchBookByPublisher(String name){
        try{
            if(name == null || name.trim().isEmpty()){
                throw new Exception("Name cannot be empty");
            }
            ArrayList<Book> books = DAO.searchBookByPublisherName(name);
            if (books == null){
                throw new Exception("No book was found with this criteria");
            }
            return books;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
