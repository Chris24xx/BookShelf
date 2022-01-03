package dev.project2.DAO.Implementation;
import dev.project2.DAO.Abstract.MediaDAO;
import dev.project2.Entities.Media;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class MediaDAOTests {

    MediaDAO mediaDAO = new MediaDAOImp();

    @Test
    void createNewMedia(){
        Media newMedia = new Media(0, "Harry Potter", "J.K. Rowling",
                "The boy who lived.", "Book", "YA Fantasy", false, 1);
        Media returnedMedia = mediaDAO.createNewMedia(newMedia);
        Assert.assertEquals(returnedMedia.getTitle(), "Harry Potter");
    }


    @Test
    void getAllMedia(){
        List<Media> allMedia = mediaDAO.getAllMedia();
        Assert.assertTrue(allMedia.size() >= 1);
    }



    @Test
    void getAllBooks(){
        List<Media> allBooks = mediaDAO.getAllBooks();
        Assert.assertTrue(allBooks.size() >= 1);
    }


    @Test
    void getAllMovies(){
        List<Media> allMovies = mediaDAO.getAllMovies();
        Assert.assertTrue(allMovies.size() >= 1);
    }


    void getAllGames(){
        List<Media> allGames = mediaDAO.getAllGames();
        Assert.assertTrue(allGames.size() >= 1);
    }


    void getMediaByTitle(){

    }


    void getAllMediaPerUser(){

    }


    void getPendingMedia(){
        List<Media> pendingMedia = mediaDAO.getPendingMedia();
        Assert.assertTrue(pendingMedia.size() >= 1);
    }


    void approveDenyMedia(){

    }

}
