import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

	private String firstName;
	private String lastName;
	private Date birthDate;
	private List<Review> reviews;
	
	public User() {
		this.reviews=new ArrayList<Review>();
	}

	public User(String firstName, String lastName, Date birthDate, List<Review> reviews) {
		super();
		this.reviews=new ArrayList<Review>();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.reviews = reviews;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
}
