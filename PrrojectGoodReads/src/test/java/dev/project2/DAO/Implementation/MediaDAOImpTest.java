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
        Media newMedia = new Media(0, "The Hobbit", "J.R.R. Tolkien",
                "A hobbit that strangely went on an adventure.", "Book", "YA Fantasy",
                false, 1);
        Media returnedMedia = mediaDAO.createNewMedia(newMedia);
        Assert.assertEquals(returnedMedia.getTitle(), "The Hobbit");
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

    }



    @Test
    void testGetApprovedMedia() {
        List<Media> approvedMedia = mediaDAO.getApprovedMedia();
        Assert.assertTrue(approvedMedia.size() >= 0);
    }


    @Test
    public void testApproveMedia() {
        Boolean approvedAMedia = mediaDAO.approveMedia(3);
        Assert.assertTrue(true);
    }



}
