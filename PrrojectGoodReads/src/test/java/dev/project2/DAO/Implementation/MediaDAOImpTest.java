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
    }

    @Test
    public void testGetAllMovies() {
    }

    @Test
    public void testGetAllGames() {
    }

    @Test
    public void testGetMediaByTitle() {
    }

    @Test
    public void testGetAllMediaPerUser() {
    }

    @Test
    public void testGetPendingMedia() {
    }

    @Test
    public void testApproveDenyMedia() {
    }



}
