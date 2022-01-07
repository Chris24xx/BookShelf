package dev.project2.Exception;

public class WebUserNotFound extends RuntimeException{
    public WebUserNotFound(String msg){
        super(msg);
    }
}
