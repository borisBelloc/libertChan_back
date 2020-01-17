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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	public String getUniqueSignature() {
		return uniqueSignature;
	}

	public void setUniqueSignature(String uniqueSignature) {
		this.uniqueSignature = uniqueSignature;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
