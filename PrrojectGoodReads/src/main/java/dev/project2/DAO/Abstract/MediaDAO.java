package dev.project2.DAO.Abstract;
import dev.project2.Entities.Media;
import java.util.List;


public interface MediaDAO {

    Media createNewMedia(Media media);

    List<Media> getAllMedia();

    List<Media> getAllBooks();

    List<Media> getAllMovies();

    List<Media> getAllGames();

    List<Media> getMediaByTitle();

    List<Media> getAllMediaPerUser();

    List<Media> getPendingMedia();

    boolean approveDenyMedia();

}
