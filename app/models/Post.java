package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author Ryan Brainard
 */
@Entity
public class Post extends Model {

    @Required
    public String title;

    public String body;

    @OneToMany
    public List<Comment> comments;

    @Override
    public String toString() {
        return title;
    }

}
