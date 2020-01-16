package kaboni.libertchan.models;

import javax.persistence.*;

@Entity
public class BannedUser {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String ip;
	
	//nombre de secondes, il faudra peut être le modifier plus tard
	@Column
	private Long duration;
	
	@Column
	private String reason;

}
