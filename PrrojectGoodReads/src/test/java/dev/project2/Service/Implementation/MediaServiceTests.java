package dev.project2.Service.Implementation;
import dev.project2.DAO.Abstract.MediaDAO;
import dev.project2.DAO.Implementation.ContactUsDAOImp;
import dev.project2.DAO.Implementation.MediaDAOImp;
import dev.project2.Entities.Media;
import dev.project2.Entities.Review;
import dev.project2.Exception.ItemNotFound;
import dev.project2.Exception.ReviewNotFound;
import dev.project2.Service.Abstract.MediaService;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MediaServiceTests {

    public static MediaDAOImp mediaDao;
    public static MediaServiceImp mediaService;

    @BeforeClass
    public void setup(){
        mediaDao = Mockito.mock(MediaDAOImp.class);
        mediaService = new MediaServiceImp(mediaDao);
    }



    @Test (expectedExceptions = ItemNotFound.class, expectedExceptionsMessageRegExp = "This piece of media does not exist")
    void approveMediaFail(){
        Mockito.when(mediaDao.approveMedia(200)).thenThrow(new ItemNotFound("This piece of media does not exist"));
        boolean media = mediaService.approveMediaService(200);
        Assert.assertTrue(media);
    }

}
