package kaboni.libertchan.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "role_")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String label;
	
	
	@ManyToMany
	@JoinTable(name = "role_has_right", 
		joinColumns = @JoinColumn(name = "role_id"),
		inverseJoinColumns = @JoinColumn(name = "right_id"))
	private Set<Right> rights;
	
	
	
	public Role() {
	}

	public Role(String label) {
		this.label = label;
	}

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
	
	public Set<Right> getRights() {
		return rights;
	}
	
	public void addRight(Right right) {
		if (rights == null) {
			rights = new HashSet<>();
		}
		rights.add(right);
	}

}
		