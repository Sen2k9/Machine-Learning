
public class Movie {
	// attributes of Movie class
	private String title;
	private String yearOfRelease;
	private int Id;
	private double rating;

	public Movie() { // no argument constructor

	}

	public Movie(String title, String yearOfRelease, int id) { // constructor

		this.title = title;
		this.yearOfRelease = yearOfRelease;
		Id = id;

	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", yearOfRelease=" + yearOfRelease + ", Id=" + Id + "]";
	}

	public int getId() {

		return Id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(String yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public void setId(int id) {
		Id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getName() {
		return this.title;
	}

	public int getIdGivenYear(String movie_year) { // method to return movie id given movie year
		if (this.yearOfRelease == movie_year)
			return this.Id;
		return 0;
	}

	public String getTitleGivenId(int id2) { // method to return movie title given movie id
		if (this.Id == id2)
			return this.title;
		return null;
	}

}
