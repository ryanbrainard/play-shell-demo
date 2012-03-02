package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Ryan Brainard
 */
@Entity
public class Comment extends Model {

    @ManyToOne(cascade = CascadeType.ALL)
    public Post post;
    
    public String body;

    @Override
    public String toString() {
        return body;
    }

}
