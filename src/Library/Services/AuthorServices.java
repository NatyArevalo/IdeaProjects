package Library.Services;

import Library.Entities.Author;
import Library.Persistence.DAOAuthor;

public class AuthorServices {
    private BookServices bookServices;
    private final DAOAuthor DAO;

    public AuthorServices() {
        this.DAO = new DAOAuthor();
    }
    public void setBookServices(BookServices bookServices){
     this.bookServices = bookServices;
    }
    public Author createAuthor(String name){
        Author author = new Author();
        try{
            if (name == null || name.trim().isEmpty()){
                throw new Exception("Name cannot be empty");
            }
            author.setName(name);
            DAO.save(author);
            return author;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Author modifyByName(String name, Boolean active){
        try{
            if (name == null || name.trim().isEmpty()){
                throw new Exception("Name cannot be empty");
            }
            Author author = searchByName(name);
            author.setActive(active);
            DAO.save(author);
            return author;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void deleteAuthorByName(String name){
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new Exception("Name cannot be empty");
            }
            Author author = searchByName(name);
            DAO.delete(author);
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
    public Author searchByName(String name){
        try{
            if (name == null || name.trim().isEmpty()){
                throw new Exception("Name cannot be empty");
            }
            Author author = DAO.searchAuthorByName(name);
            if (author == null){
                throw new Exception("No author was found with this criteria");
            }
            return author;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
