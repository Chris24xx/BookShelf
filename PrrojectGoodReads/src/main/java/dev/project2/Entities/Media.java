package dev.project2.Entities;
import java.util.Objects;

// The Media entity's class.
public class Media {

    // The Media entity's properties needed for the database table.
    private int mediaId;
    private String title;
    private String creator;
    private String synopsis;
    private String mediaType;
    private String genre;
    private boolean status;
    private int userId;


    // Both a default, no-args constructor and the constructor that sets all the properties.
    public Media(){}

    public Media(int mediaId, String title, String creator, String synopsis, String mediaType, String genre,
                 boolean status, int userId) {
        this.mediaId = mediaId;
        this.title = title;
        this.creator = creator;
        this.synopsis = synopsis;
        this.mediaType = mediaType;
        this.genre = genre;
        this.status = status;
        this.userId = userId;
    }


    // The overridden "toString()", "equals()", and "hashCode()" methods.
    @Override
    public String toString() {
        return "Media{" +
                "mediaId=" + mediaId +
                ", title='" + title + '\'' +
                ", creator='" + creator + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", genre='" + genre + '\'' +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return mediaId == media.mediaId && status == media.status && userId == media.userId && Objects.equals(title, media.title) && Objects.equals(creator, media.creator) && Objects.equals(synopsis, media.synopsis) && Objects.equals(mediaType, media.mediaType) && Objects.equals(genre, media.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediaId, title, creator, synopsis, mediaType, genre, status, userId);
    }



    // The getters and setters for each of the private properties.
    // GET AND SET MEDIA ID
    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public int getMediaId() {
        return mediaId;
    }


    // GET AND SET TITLE
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }



    // GET AND SET CREATOR
    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreator() {
        return creator;
    }



    // GET AND SET SYNOPSIS
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getSynopsis() {
        return synopsis;
    }



    // GET AND SET MEDIA TYPE
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaType() {
        return mediaType;
    }



    // GET AND SET GENRE
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }



    // GET AND SET STATUS
    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }



    // GET AND SET USER ID
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }


}
