package kaboni.libertchan.models;

import javax.persistence.*;

@Entity
public class Role {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String label;

}
