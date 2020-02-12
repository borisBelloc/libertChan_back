package kaboni.libertchan.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Message {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Date date;
	
	@Column
	private Long postNumber;
	
	@Column
	private String author;
	
	@Column
	private Boolean isFirstMessage;
	
	@Column
	private String textContent;
	
	@OneToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private Image image;
	
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
