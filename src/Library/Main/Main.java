package Library.Main;


import Library.Entities.Author;
import Library.Entities.Publisher;
import Library.Services.AuthorServices;
import Library.Services.BookServices;
import Library.Services.PublisherServices;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws Exception {
        menu();
    }
    private static void menu() throws Exception {
        AuthorServices authorServices = new AuthorServices();
        BookServices bookServices = new BookServices();
        PublisherServices publisherServices = new PublisherServices();
        Scanner input = new Scanner(System.in);
        char op;
        do{
            System.out.println("Menu");
            System.out.println("a. Insert new Author");
            System.out.println("b. Insert new Publisher");
            System.out.println("c. Insert new Book");
            System.out.println("d. Modify existent Author");
            System.out.println("e. Modify existent Publisher");
            System.out.println("f. Modify existent Book");
            System.out.println("g. Search Author by Name");
            System.out.println("h. Search Book by ISBN");
            System.out.println("i. Search Book by Title");
            System.out.println("j. Search Books by Author name");
            System.out.println("k. Search Book by Publisher name");
            System.out.println("l. Show all Books");
            System.out.println("m. Delete an existent Author");
            System.out.println("n. Delete an existent Publisher");
            System.out.println("o. Delete an existent Book");
            System.out.println("p. exit");
            op = input.next().toLowerCase().charAt(0);
            switch(op){
                case 'a':
                    System.out.println("Insert new Author");
                    System.out.println("Insert Author name");
                    input.nextLine();
                    String name = input.nextLine();
                    try{
                        authorServices.createAuthor(name);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'b':
                    System.out.println("Insert new Publisher");
                    System.out.println("Insert Publisher name");
                    input.nextLine();
                    name = input.nextLine();
                    try{
                        publisherServices.createPublisher(name);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'c':
                    System.out.println("Insert new Book");
                    System.out.println("Insert Book title");
                    input.nextLine();
                    String title = input.nextLine();
                    System.out.println("Insert Book ISBN");
                    Long ISBN = input.nextLong();
                    System.out.println("Insert Book year");
                    Integer anio = input.nextInt();
                    System.out.println("Insert number of copies of book");
                    Integer copies = input.nextInt();
                    System.out.println("Insert number of borrowed copies");
                    Integer borrowedCopies = input.nextInt();
                    System.out.println("Insert number of remaining copies");
                    Integer remainingCopies = input.nextInt();
                    System.out.println("Insert Author name");
                    input.nextLine();
                    String authorName = input.nextLine();
                    Author author = authorServices.searchByName(authorName);
                    System.out.println("Insert Publisher name");
                    String publisherName = input.nextLine();
                    Publisher publisher = publisherServices.searchByName(publisherName);
                    try{
                        bookServices.createBook(ISBN, title, anio, copies, borrowedCopies, remainingCopies, author, publisher);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'd':
                    System.out.println("Modify Author");
                    System.out.println("Insert author name to be modified");
                    input.nextLine();
                    String modifyName = input.nextLine();
                    System.out.println("Deactivate author? y/n");
                    char op1 = input.next().charAt(0);
                    Boolean active = true;
                    if(op1 == 'y'){
                        active = false;
                    }
                    authorServices.modifyByName(modifyName, active);
                    break;
                case 'e':
                    System.out.println("Modify Publisher");
                    System.out.println("Insert publisher name to be modified");
                    input.nextLine();
                    modifyName = input.nextLine();
                    System.out.println("Deactivate author? y/n");
                    op1 = input.next().charAt(0);
                    active = true;
                    if(op1 == 'y'){
                        active = false;
                    }
                    authorServices.modifyByName(modifyName, active);
                    break;
                case 'f':
                    System.out.println("Modify Book");
                    System.out.println("Insert book title");
                    input.nextLine();
                    modifyName = input.nextLine();
                    System.out.println("Insert number of copies");
                    Integer modifycopies = input.nextInt();;
                    System.out.println("Insert number of borrowed copies");
                    Integer modifyBorrowedCopies = input.nextInt();
                    Integer modifyRemainingCopieis = modifycopies - modifyBorrowedCopies;
                    System.out.println("Deactivate book? y/n");
                    op1 = input.next().charAt(0);
                    active = true;
                    if(op1 == 'y'){
                        active = false;
                    }
                    bookServices.modifyBookByTitle(modifyName, modifycopies, modifyBorrowedCopies, modifyRemainingCopieis, active);

                    break;
                case 'g':
                    System.out.println("Search Author By Name");
                    System.out.println("Insert Author Name to Search");
                    input.nextLine();
                    String searchName = input.nextLine();
                    System.out.println(authorServices.searchByName(searchName).toString());
                    break;
                case 'h':
                    System.out.println("Search Book by ISBN");
                    System.out.println("Insert ISBN to search");
                    input.nextLine();
                    Long searchISBN = input.nextLong();
                    System.out.println(bookServices.searchBookByISBN(searchISBN).toString());
                    break;
                case 'i':
                    System.out.println("Search Book by Title");
                    System.out.println("Insert book title to search");
                    input.nextLine();
                    String searchTitle = input.nextLine();
                    System.out.println(bookServices.searchBookByTitle(searchTitle).toString());
                    break;
                case 'j':
                    System.out.println("Search Book by Author name");
                    System.out.println("Insert book/s author name to search");
                    input.nextLine();
                    String searchAuthor = input.nextLine();
                    System.out.println(bookServices.searchBookByAuthor(searchAuthor).toString());
                    break;
                case 'k':
                    System.out.println("Search Book by Publisher name");
                    System.out.println("Insert book/s publisher name to search");
                    input.nextLine();
                    String searchPublisher = input.nextLine();
                    System.out.println(bookServices.searchBookByPublisher(searchPublisher).toString());
                    break;
                case 'l':
                    System.out.println("--------------ALL BOOKS------------------");
                    System.out.println(bookServices.showAllBooks().toString());
                    break;
                case 'm':
                    System.out.println("Delete an existent Author");
                    System.out.println("Insert author name to delete");
                    input.nextLine();
                    String deleteName = input.nextLine();
                    authorServices.deleteAuthorByName(deleteName);
                    break;
                case 'n':
                    System.out.println("Delete an existent Publisher");
                    System.out.println("Insert publisher name to delete");
                    input.nextLine();
                    deleteName = input.nextLine();
                    publisherServices.deletePublisherByName(deleteName);
                    break;
                case 'o':
                    System.out.println("Delete an existent Book");
                    System.out.println("Insert ISBN to delete");
                    input.nextLine();
                    Long deleteISBN = input.nextLong();
                    bookServices.deleteBookByISBN(deleteISBN);
                    break;
                default:
                    System.out.println("Option entered is not valid");
                    System.out.println("Please enter a valid option");
                    break;
            }

        }while(op != 'p');
    }


}
