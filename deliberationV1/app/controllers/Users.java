package controllers;

import models.CommentCollection;
import models.User;
import play.libs.Json;
import play.mvc.*;

public class Users extends Controller{

    /**
     * Return all the comments by user
     */
    public static Result findCommentsByUser(Long userId){
        CommentCollection comments = User.findAllCommentsByUser(userId);
        return ok(Json.toJson(comments));
    }

}
