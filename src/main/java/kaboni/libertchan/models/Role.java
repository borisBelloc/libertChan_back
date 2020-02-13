package kaboni.libertchan.models;

import javax.persistence.*;

@Entity
public class Role {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String label;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
		