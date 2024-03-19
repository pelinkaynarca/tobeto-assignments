
public class Review {
	private String content;
	private int rating;
	private User user;
	
	public Review() {
		super();
	}

	public Review(String content, int rating, User user) {
		super();
		this.content = content;
		this.rating = rating;
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}
}
