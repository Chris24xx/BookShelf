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
        Media newMedia = new Media(0, "Test Media", "Test",
                "Testing test delete.", "Game", "Action",
                false, 4);
        Media returnedMedia = mediaDAO.createNewMedia(newMedia);
        Assert.assertEquals(returnedMedia.getTitle(), "Test Media");
    }


    @Test
    void testGetMediaByUserId(){
        List<Media> allMedia = mediaDAO.getMediaByUserId(3);
        Assert.assertTrue(allMedia.size() >= 2);
    }



    @Test
    public void testGetAllBooks() {
        List<Media> allBooks = mediaDAO.getAllBooks();
        Assert.assertTrue(allBooks.size() >= 2);
    }


    @Test
    public void testGetAllMovies() {
        List<Media> allMovies = mediaDAO.getAllMovies();
        Assert.assertTrue(allMovies.size() >= 1);
    }



    @Test
    public void testGetAllGames() {
        List<Media> allGames = mediaDAO.getAllGames();
        Assert.assertTrue(allGames.size() >= 1);
    }


    @Test
    public void testGetPendingMedia() {
        List<Media> pendingMedia = mediaDAO.getPendingMedia();
        Assert.assertTrue(pendingMedia.size() >= 1);
    }



    @Test
    void testGetApprovedMedia() {
        List<Media> approvedMedia = mediaDAO.getApprovedMedia();
        Assert.assertTrue(approvedMedia.size() >= 1);
    }


    @Test
    public void testApproveMedia() {
        Boolean approvedAMedia = mediaDAO.approveMedia(80);
        Assert.assertTrue(true);
    }



    @Test
    void testDeleteMedia() {
        boolean deletedMedia = mediaDAO.deleteMedia(63);
        Assert.assertTrue(deletedMedia);
    }

}
