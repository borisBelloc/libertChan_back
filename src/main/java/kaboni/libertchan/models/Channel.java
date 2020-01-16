package kaboni.libertchan.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Channel {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column 
	private String theme;
	
	@Column
	private String name;
	
	@Column
	private String shortName;
	
	@Column
	private Integer messageMaxByThread;
	
	@Column
	private Long maxTimeWithoutPost;
	
}
