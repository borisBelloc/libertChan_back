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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
