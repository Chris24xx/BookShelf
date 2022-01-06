package dev.project2.controllers;
import com.google.gson.Gson;
import dev.project2.Entities.Media;
import dev.project2.Exception.ItemNotFound;
import dev.project2.Exception.TitleNotFound;
import dev.project2.Service.Abstract.MediaService;
import io.javalin.http.Handler;

import java.util.List;


public class MediaController {

    MediaService mediaService;

    public MediaController(MediaService mediaService){
        this.mediaService = mediaService;
    }


    public Handler createMedia = ctx -> {
        Gson gson = new Gson();
        Media newMedia = gson.fromJson(ctx.body(), Media.class);
        Media createdMedia = this.mediaService.createNewMediaService(newMedia);
        String createdMediaJson = gson.toJson(createdMedia);
        ctx.result(createdMediaJson);
        ctx.status(201);
    };


    public Handler getAllBooks = ctx -> {
        List<Media> books = this.mediaService.getAllBooksService();
        Gson gson = new Gson();
        String booksJSONs = gson.toJson(books);
        ctx.result(booksJSONs);
        ctx.status(200);
    };


    public Handler getAllMovies = ctx -> {
        List<Media> movies = this.mediaService.getAllMoviesService();
        Gson gson = new Gson();
        String moviesJSONs = gson.toJson(movies);
        ctx.result(moviesJSONs);
        ctx.status(200);
    };



    public Handler getAllGames = ctx -> {
        List<Media> games = this.mediaService.getAllGamesService();
        Gson gson = new Gson();
        String gamesJSONs = gson.toJson(games);
        ctx.result(gamesJSONs);
        ctx.status(200);
    };


    public Handler getMediaByTitle = ctx -> {
        String title = ctx.pathParam("title");
        try {
            Media media = this.mediaService.getMediaByTitleService(title);
            Gson gson = new Gson();
            String mediaJson = gson.toJson(media);
            ctx.result(mediaJson);
            ctx.status(200);
        } catch (TitleNotFound t) {
            ctx.result(t.getMessage());
            ctx.status(404);
        }
    };



    // TROUBLE
    public Handler getPendingMedia = ctx -> {
        List<Media> pendingMedia = this.mediaService.getPendingMediaService();
        Gson gson = new Gson();
        String pendingJSONs = gson.toJson(pendingMedia);
        ctx.result(pendingJSONs);
        ctx.status(200);
    };


    // TROUBLE
    public Handler getApprovedMedia = ctx -> {
        List<Media> approvedMedia = this.mediaService.getApprovedMediaService();
        Gson gson = new Gson();
        String approvedJSONs = gson.toJson(approvedMedia);
        ctx.result(approvedJSONs);
        ctx.status(200);
    };



    // TROUBLE
    public Handler approveMedia = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        try {
            boolean media = this.mediaService.approveMediaService(id);
//            Gson gson = new Gson();
//            String mediaJson = gson.toJson(media);
            ctx.result(String.valueOf(media));
            ctx.status(200);
        } catch (ItemNotFound i) {
            ctx.result(i.getMessage());
            ctx.status(404);
        }
    };



    // TROUBLE
    public Handler deleteMedia = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        try {
            boolean media = this.mediaService.deleteMediaService(id);
//            Gson gson = new Gson();
//            String mediaJson = gson.toJson(media);
            ctx.result(String.valueOf(media));
            ctx.status(200);
        } catch (ItemNotFound i) {
            ctx.result(i.getMessage());
            ctx.status(404);
        }
    };


}
