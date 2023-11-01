package Library.Services;

import Library.Entities.Publisher;
import Library.Persistence.DAOPublisher;

public class PublisherServices {
    private BookServices bookServices;
    private final DAOPublisher DAO;

    public PublisherServices() {
        this.DAO = new DAOPublisher();
    }
    public void setBookServices(BookServices bookServices){
        this.bookServices = bookServices;
    }
    public Publisher createPublisher(String name){
        Publisher publisher = new Publisher();
        try{
            if (name == null || name.trim().isEmpty()){
                throw new Exception("Name cannot be empty");
            }
            publisher.setName(name);
            DAO.save(publisher);
            return publisher;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Publisher modifyByName(String name, Boolean active){
        try{
            if (name == null || name.trim().isEmpty()){
                throw new Exception("Name cannot be empty");
            }
            Publisher publisher = searchByName(name);
            publisher.setName(name);
            publisher.setActive(active);
            DAO.save(publisher);
            return publisher;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void deletePublisherByName(String name){
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new Exception("Name cannot be empty");
            }
            Publisher publisher = searchByName(name);
            DAO.delete(publisher);
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
    public Publisher searchByName(String name){
        try{
            if (name == null || name.trim().isEmpty()){
                throw new Exception("Name cannot be empty");
            }
            Publisher publisher = DAO.searchPublisherByName(name);
            if (publisher == null){
                throw new Exception("No author was found with this criteria");
            }
            return publisher;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
