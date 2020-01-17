package kaboni.libertchan.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Image {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String imageLocation;
	
	@Column
	private String uniqueSignature;
	
	@Column
	private String imageName;
	
	@Column
	private String extension;
	
	@OneToOne
	private Message message;

}
