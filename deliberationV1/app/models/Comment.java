package models;

import play.db.ebean.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Entity
public class Comment extends Model {

    @Id
    private Long _id;
    @NotNull
    private User user;
    @NotNull
    private String comment;
    @NotNull
    private Date date;
    @OneToMany(mappedBy = "comment")
    private List<Tag> tags;
    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<ExternalResource> externalResources;

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<ExternalResource> getExternalResources() {
        return externalResources;
    }

    public void setExternalResources(List<ExternalResource> externalResources) {
        this.externalResources = externalResources;
    }
}
