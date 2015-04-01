package models;

import enums.ExternalResourceTypes;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class ExternalResource extends Model{

    @Id
    private String _id;
    @NotNull
    private String link;
    private String alias;
    @NotNull
    private ExternalResourceTypes type;
    @ManyToOne
    private Comment comment;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public ExternalResourceTypes getType() {
        return type;
    }

    public void setType(ExternalResourceTypes type) {
        this.type = type;
    }
}
