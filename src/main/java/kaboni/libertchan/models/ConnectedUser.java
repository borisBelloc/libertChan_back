package kaboni.libertchan.models;

import javax.persistence.*;

@Entity
public class ConnectedUser {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String mail;
	
	@Column
	private Integer karma;
	
	@Column
	private String mainPseudo;
	
	@Column
	private String password;
	
	@Column
	private Integer accessLevel;

}
