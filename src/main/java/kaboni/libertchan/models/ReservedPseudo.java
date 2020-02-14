package kaboni.libertchan.models;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class ReservedPseudo {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String pseudo;
	
	@Column
	private String ip;
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column
	private LocalDate expirationDate;
	
	@ManyToOne
	private ConnectedUser user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public ConnectedUser getUser() {
		return user;
	}

	public void setUser(ConnectedUser user) {
		this.user = user;
	}

}
