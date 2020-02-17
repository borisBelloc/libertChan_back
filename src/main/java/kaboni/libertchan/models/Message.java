package kaboni.libertchan.models;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
public class Message {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private LocalDateTime date;

	@Column
	private Long postNumber;
	
	@Column
	private String author;
	
	@Column
	private Boolean isFirstMessage;
	
	@Column(length = 1000)
	private String textContent;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@NotFound(action=NotFoundAction.IGNORE)
	private Image image;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "discussion_thread_id")
	private DiscussionThread discussionThread;
	
	@OneToOne
	private ConnectedUser user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Long getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(Long postNumber) {
		this.postNumber = postNumber;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Boolean getIsFirstMessage() {
		return isFirstMessage;
	}

	public void setIsFirstMessage(Boolean isFirstMessage) {
		this.isFirstMessage = isFirstMessage;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public DiscussionThread getDiscussionThread() {
		return discussionThread;
	}

	public void setDiscussionThread(DiscussionThread discussionThread) {
		this.discussionThread = discussionThread;
	}

	public ConnectedUser getUser() {
		return user;
	}

	public void setUser(ConnectedUser user) {
		this.user = user;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

}
