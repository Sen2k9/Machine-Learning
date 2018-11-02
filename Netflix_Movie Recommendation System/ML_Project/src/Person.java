import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Person {
	// Attributes for Person class
	private int ID;
	private Map<Integer, Double> moviewithRating; // Maping all movie id with it's corresponding rating

	public Map<Integer, Double> getMoviewithRating() { // get a movie with its rating
		return moviewithRating;
	}

	public Person(int id, Map<Integer, Double> moviewithRating) { // constructor
		this.ID = id;
		this.moviewithRating = moviewithRating;
		moviewithRating = new HashMap<>();

	}

	public Person() { // no argument constructor

	}

	public void setMoviewithRating(int movie, double rating) {
		this.moviewithRating.put(movie, rating);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Person getPerson(int id) { // get Person instance given it's id
		if (id == this.ID)
			return this;
		return null;

	}

	public ArrayList<Double> getAllRatings() { // method to get all ratings given by this person instance
		ArrayList<Double> ratings = new ArrayList<>();
		Map<Integer, Double> treeMap = new TreeMap<>(moviewithRating);
		treeMap.forEach((movie, rating) -> ratings.add(rating));
		return ratings;
	}

	public ArrayList<Double> getAllRatingsGivenId(int user_id) { // method to get all ratings given by person's id
		if (this.ID == user_id) {
			ArrayList<Double> ratings = new ArrayList<>();
			Map<Integer, Double> treeMap = new TreeMap<>(this.moviewithRating);
			treeMap.forEach((movie, rating) -> ratings.add(rating));
			return ratings;
		}
		return null;
	}

	public ArrayList<Integer> getAllMovies() { // method to get all movies which this person has reviewed
		ArrayList<Integer> movies = new ArrayList<>();
		Map<Integer, Double> treeMap = new TreeMap<>(moviewithRating);
		treeMap.forEach((movie, rating) -> movies.add(movie));
		return movies;
	}

	public int getMovie(double rating) { // method to get movie given it's rating
		Map<Integer, Double> treeMap = new TreeMap<>(moviewithRating);
		int movie_id = 0;
		for (Map.Entry<Integer, Double> entry : treeMap.entrySet()) {
			if (entry.getValue() == rating) {
				movie_id = entry.getKey();

			}
		}

		return movie_id;

	}

	public double getRating(int movie_id) { // method to get rating of a movie given it's id
		Map<Integer, Double> treeMap = new TreeMap<>(moviewithRating);
		double ratings = 0;
		for (Map.Entry<Integer, Double> entry : treeMap.entrySet()) {
			if (entry.getKey() == movie_id) {
				ratings = entry.getValue();

			}
		}

		return ratings;

	}

	public boolean hasRated(int movie) { // return boolean value if a movie has rated by this person
		int movie_id = movie;

		if (moviewithRating.get(movie_id) == null)
			return false;
		else
			return true;
	}

	@Override
	public String toString() {
		return "Person [moviewithRating=" + moviewithRating + ", movies=" + ID + "]";
	}
}
