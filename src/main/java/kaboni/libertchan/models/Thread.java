package kaboni.libertchan.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	
	

}
