import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Media {

	private Date releaseDate;
	private double rating;
	private List<Director> directors;
	private List<Star> casts;
	private List<Writer> writers;
	private String storyLine;
	private List<Genre> genres;
	private int runtime;
	private List<String> languages;
	private List<String> photos;
	private List<String> videos;
	private List<Review> reviews;

	public Media() {
		super();
		this.directors = new ArrayList<Director>();
		this.casts = new ArrayList<Star>();
		this.writers = new ArrayList<Writer>();
		this.genres = new ArrayList<Genre>();
		this.languages = new ArrayList<String>();
		this.photos = new ArrayList<String>();
		this.videos = new ArrayList<String>();
		this.reviews = new ArrayList<Review>();
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public List<Star> getCasts() {
		return casts;
	}

	public void setCasts(List<Star> casts) {
		this.casts = casts;
	}

	public List<Writer> getWriters() {
		return writers;
	}

	public void setWriters(List<Writer> writers) {
		this.writers = writers;
	}

	public String getStoryLine() {
		return storyLine;
	}

	public void setStoryLine(String storyLine) {
		this.storyLine = storyLine;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

	public List<String> getVideos() {
		return videos;
	}

	public void setVideos(List<String> videos) {
		this.videos = videos;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
