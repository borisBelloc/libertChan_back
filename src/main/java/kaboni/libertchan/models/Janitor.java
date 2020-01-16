package kaboni.libertchan.models;

import javax.persistence.*;

@Entity
public class Janitor extends ConnectedUser{
	
	@Id
	@GeneratedValue
	private Long id;

}
