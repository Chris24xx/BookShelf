package dev.project2.Service.Implementation;
import dev.project2.DAO.Abstract.MediaDAO;
import dev.project2.DAO.Implementation.MediaDAOImp;
import dev.project2.Exception.ItemNotFound;
import dev.project2.Exception.TitleNotFound;
import dev.project2.Service.Abstract.MediaService;
import org.testng.annotations.Test;

public class MediaServiceTests {

    MediaDAO mediaDAO = new MediaDAOImp();
    MediaService mediaService = new MediaServiceImp(mediaDAO);



    @Test(expectedExceptions = TitleNotFound.class, expectedExceptionsMessageRegExp = "Title was not found")
    void testGetMediaByTitleService(){
        mediaService.getMediaByTitleService("Capture the Flag");
    }


    @Test(expectedExceptions = ItemNotFound.class,
            expectedExceptionsMessageRegExp = "This piece of media does not exist")
    void testApproveMediaService(){
        mediaService.approveMediaService(10);
    }

}
