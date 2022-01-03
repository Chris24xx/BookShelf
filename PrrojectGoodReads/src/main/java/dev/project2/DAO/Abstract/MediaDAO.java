package dev.project2.DAO.Abstract;
import dev.project2.Entities.Media;
import java.util.List;


public interface MediaDAO {

    Media createNewMedia(Media media);

    List<Media> getAllMedia();

    List<Media> getAllBooks();

    List<Media> getAllMovies();

    List<Media> getAllGames();

    Media getMediaByTitle(String title);

    List<Media> getAllMediaPerUser(int userId);

    List<Media> getPendingMedia();

    List<Media> getApprovedMedia();

    boolean approveMedia(int mediaId); // Seventh

    boolean deleteMedia(int mediaId); // Eighth

}
