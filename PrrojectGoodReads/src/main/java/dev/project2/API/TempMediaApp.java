package dev.project2.API;

import dev.project2.DAO.Abstract.MediaDAO;
import dev.project2.DAO.Implementation.MediaDAOImp;
import dev.project2.Service.Abstract.MediaService;
import dev.project2.Service.Implementation.MediaServiceImp;
import dev.project2.controllers.MediaController;
import io.javalin.Javalin;

public class TempMediaApp {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.enableDevLogging();
            config.enableCorsForAllOrigins();
        });


        MediaDAO mediaDAO = new MediaDAOImp();
        MediaService mediaService = new MediaServiceImp(mediaDAO);
        MediaController mediaController = new MediaController(mediaService);


        app.post("/newMedia", mediaController.createMedia);
        app.get("/books", mediaController.getAllBooks);
        app.get("/movies", mediaController.getAllMovies);
        app.get("/games", mediaController.getAllGames);
        app.get("/title/{title}", mediaController.getMediaByTitle);
        app.get("/pendingMedia", mediaController.getPendingMedia);     // TROUBLE
        app.get("/approvedMedia", mediaController.getApprovedMedia);   // TROUBLE
        app.get("/approveMedia/{mediaId}", mediaController.approveMedia);  // TROUBLE
        app.get("/deleteMedia/{mediaId}", mediaController.deleteMedia);   // TROUBLE



        app.start();

    }
}
