package dev.project2.DAO.Abstract;
import dev.project2.Entities.Media;
import java.util.List;


public interface MediaDAO {

    Media createNewMedia(Media media); // Fourth

    List<Media> getAllMedia(); // First

    List<Media> getAllBooks(); // SecondA

    List<Media> getAllMovies();  // SecondB

    List<Media> getAllGames();  // SecondC

    List<Media> getMediaByTitle(); // Third

    List<Media> getAllMediaPerUser(); // Fifth

    List<Media> getPendingMedia(); // Sixth

    boolean approveDenyMedia(); // Seventh

}
