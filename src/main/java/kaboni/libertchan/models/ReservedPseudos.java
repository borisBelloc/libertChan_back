package kaboni.libertchan.models;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class ReservedPseudos {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String pseudo;
	
	@Column
	private LocalDate expirationDate;

}
