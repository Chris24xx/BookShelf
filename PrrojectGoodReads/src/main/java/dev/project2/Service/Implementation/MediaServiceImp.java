package dev.project2.Service.Implementation;
import dev.project2.DAO.Abstract.MediaDAO;
import dev.project2.Entities.Media;
import dev.project2.Exception.ItemNotFound;
import dev.project2.Exception.TitleNotFound;
import dev.project2.Service.Abstract.MediaService;
import java.util.List;


public class MediaServiceImp implements MediaService {

    MediaDAO mediaDAO;

    public MediaServiceImp (MediaDAO mediaDAO) {
        this.mediaDAO = mediaDAO;
    }


    @Override
    public Media createNewMediaService(Media media) {
        return this.mediaDAO.createNewMedia(media);
    }

    @Override
    public List<Media> getMediaByUserIdService(int userId) {
        return this.mediaDAO.getMediaByUserId(userId);
    }

    @Override
    public List<Media> getAllBooksService() {
        return this.mediaDAO.getAllBooks();
    }

    @Override
    public List<Media> getAllMoviesService() {
        return this.mediaDAO.getAllMovies();
    }

    @Override
    public List<Media> getAllGamesService() {
        return this.mediaDAO.getAllGames();
    }


    @Override
    public Media getMediaByTitleService(String title) {
        try {
            return this.mediaDAO.getMediaByTitle(title);
        } catch (TitleNotFound t) {
            throw new TitleNotFound("Title was not found");
        }
    }


    @Override
    public List<Media> getPendingMediaService() {
        return this.mediaDAO.getPendingMedia();
    }

    @Override
    public List<Media> getApprovedMediaService() {
        return this.mediaDAO.getApprovedMedia();
    }



    @Override
    public boolean approveMediaService(int mediaId) {
        try {
            return this.mediaDAO.approveMedia(mediaId);
        } catch (ItemNotFound i) {
            throw new ItemNotFound("This piece of media does not exist");
        }
    }



    @Override
    public boolean deleteMediaService(int mediaId) {
        return this.mediaDAO.deleteMedia(mediaId);
    }


}
