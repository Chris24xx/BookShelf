package dev.project2.DAO.Abstract;
import dev.project2.Entities.Media;
import java.util.List;


public interface MediaDAO {

    Media createNewMedia(Media media);

    List<Media> getMediaByUserId(int userId);

    List<Media> getAllBooks();

    List<Media> getAllMovies();

    List<Media> getAllGames();

    List<Media> getPendingMedia();

    List<Media> getApprovedMedia();

    boolean approveMedia(int mediaId);

    boolean deleteMedia(int mediaId);

}
