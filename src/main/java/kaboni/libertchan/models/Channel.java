package kaboni.libertchan.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Channel {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String shortName;
	
	@Column
	private Integer messageMaxByThread;
	
	@Column
	private Long maxTimeWithoutPost;
	
	@Column
	private Boolean isPublic;
	
	@Column
	private Boolean isModerated;
	
	@Column
	private String shortDescription;
	
	
	
	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Boolean getIsModerated() {
		return isModerated;
	}

	public void setIsModerated(Boolean isModerated) {
		this.isModerated = isModerated;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@OneToMany
	private List<Thread> threads;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Integer getMessageMaxByThread() {
		return messageMaxByThread;
	}

	public void setMessageMaxByThread(Integer messageMaxByThread) {
		this.messageMaxByThread = messageMaxByThread;
	}

	public Long getMaxTimeWithoutPost() {
		return maxTimeWithoutPost;
	}

	public void setMaxTimeWithoutPost(Long maxTimeWithoutPost) {
		this.maxTimeWithoutPost = maxTimeWithoutPost;
	}

	public List<Thread> getThreads() {
		return threads;
	}

	public void setThreads(List<Thread> threads) {
		this.threads = threads;
	}
	
}
