package kaboni.libertchan.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	
	

}
