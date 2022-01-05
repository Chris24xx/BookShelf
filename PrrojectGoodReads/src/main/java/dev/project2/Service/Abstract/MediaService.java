package dev.project2.Service.Abstract;

import dev.project2.Entities.Media;

import java.util.List;

public interface MediaService {

    Media createNewMediaService(Media media);

    List<Media> getAllMediaService();

    List<Media> getAllBooksService();

    List<Media> getAllMoviesService();

    List<Media> getAllGamesService();

    Media getMediaByTitleService(String title);

    List<Media> getAllMediaPerUserService(int userId);

    List<Media> getPendingMediaService();

    List<Media> getApprovedMediaService();

    boolean approveMediaService(int mediaId);

    boolean deleteMediaService(int mediaId);

}