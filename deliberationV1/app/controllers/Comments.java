package controllers;

import models.Comment;
import models.CommentCollection;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.*;

public class Comments extends Controller{

    /**
     * Return all the comments
     */
    public static Result findComments() {
        CommentCollection comments = Comment.findAll();
        return ok(Json.toJson(comments));
    }

    /**
     * Return one comment by id
     */
    public static Result findCommentById(Long id) {
        Comment comment = Comment.findById(id);
        return ok(Json.toJson(comment));
    }

    /**
     * Delete one comment
     */
    public static Result deleteComment(Long id) {
        Comment.delete(id);
        return redirect("/api/comments");
    }
}
