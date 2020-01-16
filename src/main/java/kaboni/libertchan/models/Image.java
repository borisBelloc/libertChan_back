package kaboni.libertchan.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Image {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String uniqueSignature;
	
	@Column
	private String name;
	
	@Column
	private String extension;

}
