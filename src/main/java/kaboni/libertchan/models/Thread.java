package kaboni.libertchan.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Thread {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String subject;
	
	@Column
	private Long authorId;
	
	@Column
	private Date timer;
	
	@Column
	private Integer messageCount;
	
	@Column
	private Integer imageCount;
	
	@OneToMany
	private List<Message> messages;
	
	@ManyToOne
	private Channel channel;

}
