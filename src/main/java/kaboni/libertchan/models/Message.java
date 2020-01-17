package kaboni.libertchan.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Message {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Date date;
	
	@Column
	private Long postNumber;
	
	@Column
	private String author;
	
	@Column
	private Boolean isFirstMessage;
	
	@OneToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private Image image;
	
	@ManyToOne
	private Thread thread;
	
	@OneToOne
	private ConnectedUser user;

}
