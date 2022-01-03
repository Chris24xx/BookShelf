package dev.project2.DAO.Implementation;

import dev.project2.DAO.Abstract.MediaDAO;
import dev.project2.Entities.Media;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;


public class MediaDAOImpTest {

    MediaDAO mediaDAO = new MediaDAOImp();

    @Test
    void testCreateNewMedia(){
        Media newMedia = new Media(0, "Harry Potter", "J.K. Rowling",
                "The boy who lived.", "Book", "YA Fantasy", false, 1);
        Media returnedMedia = mediaDAO.createNewMedia(newMedia);
        Assert.assertEquals(returnedMedia.getTitle(), "Harry Potter");
    }


    @Test
    void testGetAllMedia(){
        List<Media> allMedia = mediaDAO.getAllMedia();
        Assert.assertTrue(allMedia.size() >= 1);
    }



    @Test
    public void testGetAllBooks() {
        List<Media> allBooks = mediaDAO.getAllBooks();
        Assert.assertTrue(allBooks.size() >= 1);
    }


    @Test
    public void testGetAllMovies() {
        List<Media> allMovies = mediaDAO.getAllMovies();
        Assert.assertTrue(allMovies.size() >= 0);
    }



    @Test
    public void testGetAllGames() {
        List<Media> allGames = mediaDAO.getAllGames();
        Assert.assertTrue(allGames.size() >= 0);
    }

    @Test
    public void testGetMediaByTitle() {
        Media mediaTitle = mediaDAO.getMediaByTitle("Harry Potter");
        Assert.assertEquals(mediaTitle.getTitle(), "Harry Potter");
    }



    @Test
    public void testGetAllMediaPerUser() {
        List<Media> userMedia = mediaDAO.getAllMediaPerUser(1);
        Assert.assertTrue(userMedia.size() >= 1);
    }



    @Test
    public void testGetPendingMedia() {
        List<Media> pendingMedia = mediaDAO.getPendingMedia();
        Assert.assertTrue(pendingMedia.size() >= 1);
    }



    @Test
    public void testApproveDenyMedia() {
    }



}
