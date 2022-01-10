package dev.project2.Service.Abstract;

import dev.project2.Entities.Media;

import java.util.List;

public interface MediaService {

    Media createNewMediaService(Media media);

    List<Media> getMediaByUserIdService(int userId);

    List<Media> getAllBooksService();

    List<Media> getAllMoviesService();

    List<Media> getAllGamesService();

    List<Media> getPendingMediaService();

    List<Media> getApprovedMediaService();

    boolean approveMediaService(int mediaId);

    boolean deleteMediaService(int mediaId);

}
