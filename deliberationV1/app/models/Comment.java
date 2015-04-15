package models;

import com.avaje.ebean.ExpressionList;
import play.db.ebean.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Comment extends Model {

    @Id
    @GeneratedValue
    private Long commentId;
    @NotNull
    private String comment;
    @NotNull
    private Date commentDate;
    @ManyToMany
    private List<Tag> commentTags = new ArrayList<Tag>();
    @ManyToMany(cascade = CascadeType.ALL)
    private List<ExternalResource> commentExternalResources = new ArrayList<ExternalResource>();

    public Comment(String comment, Date date, List<Tag> tags, List<ExternalResource> externalResources) {
        this.comment = comment;
        this.commentDate = date;
        this.commentTags = tags;
        this.commentExternalResources = externalResources;
    }

    public static Finder<Long, Comment> find = new Finder<Long, Comment>(Long.class, Comment.class);

    public static CommentCollection findAll() {
        List<Comment> comments = find.all();
        CommentCollection commentCollection = new CommentCollection();
        commentCollection.setComments(comments);
        return commentCollection;
    }

    public static Comment findById(Long id) {
        return find.ref(id);
    }

    /*
     * Getters and setters
     */

    public Long get_id() {
        return commentId;
    }

    public void set_id(Long _id) {
        this.commentId = _id;
    }

    public String getComment() {
        return comment;

    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return commentDate;
    }

    public void setDate(Date date) {
        this.commentDate = date;
    }

    public List<Tag> getTags() {
        return commentTags;
    }

    public void setTags(List<Tag> tags) {
        this.commentTags = tags;
    }

    public List<ExternalResource> getExternalResources() {
        return commentExternalResources;
    }

    public void setExternalResources(List<ExternalResource> externalResources) {
        this.commentExternalResources = externalResources;
    }
}
