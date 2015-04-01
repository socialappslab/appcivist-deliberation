package models;


import enums.TagTypes;
import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Tag extends Model{

    @Id
    private String name;
    @NotNull
    private TagTypes type;
    @ManyToOne
    private Comment comment;


    /*
     * Getters and setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TagTypes getType() {
        return type;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void setType(TagTypes type) {
        this.type = type;
    }
}
