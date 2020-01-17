package kaboni.libertchan.models;

import java.util.List;

import javax.persistence.*;

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
	
	@OneToMany
	private List<Thread> threads;
	
}
