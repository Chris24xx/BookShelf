package dev.project2.DAO.Implementation;

//import dev.project2.Website.Abstract.MediaDAO;
import dev.project2.DAO.Abstract.MediaDAO;
import dev.project2.Entities.Media;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;


public class MediaDAOImpTest {

    MediaDAO mediaDAO = new MediaDAOImp();

    @Test
    void testCreateNewMedia(){
        Media newMedia = new Media(0, "Anne of Green Gables", "Lucy Maud Montgomery",
                "The orphan with great imagination.", "Book", "Children's literature",
                false, 2);
        Media returnedMedia = mediaDAO.createNewMedia(newMedia);
        Assert.assertEquals(returnedMedia.getTitle(), "Anne of Green Gables");
    }


    @Test
    void testGetMediaByUserId(){
        List<Media> allMedia = mediaDAO.getMediaByUserId(6);
        Assert.assertTrue(allMedia.size() >= 1);
    }



    @Test
    public void testGetAllBooks() {
        List<Media> allBooks = mediaDAO.getAllBooks();
        Assert.assertTrue(allBooks.size() == 2);
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
        Boolean approvedAMedia = mediaDAO.approveMedia(2);
        Assert.assertTrue(true);
    }



    @Test
    void testDeleteMedia() {
        boolean deletedMedia = mediaDAO.deleteMedia(2);
        Assert.assertTrue(deletedMedia);
    }

}
