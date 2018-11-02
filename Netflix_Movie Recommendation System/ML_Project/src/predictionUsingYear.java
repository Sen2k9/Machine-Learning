import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class predictionUsingYear {

	public void recommendMovie(int userId, String movie_year) { // method to recommend movie given user id and movie
																// year
		test tester = new test();
		recommender r = new recommender();
		LinkedList<Movie> movielist = new LinkedList<>();
		movielist = tester.getAllMovie(); // All movies are invoked

		Map<Double, String> ratingWithTitleMap = new HashMap<>(); // Maping predicted movie rating with title
		Map<Integer, String> movieMap = new HashMap<>(); // Maping movie id with title

		for (Movie m : movielist) {

			if (m.getYearOfRelease().equals(movie_year)) {
				for (Person alluser : tester.getAllPerson()) {
					if (alluser.getID() == userId) {
						if (alluser.hasRated(m.getId()) == false) {
							movieMap.put(m.getId(), m.getTitle());
						}
					}

				}

			}
		}

		Map<Integer, String> treeMap = new TreeMap<>(movieMap); // Sorting movie title with id

		treeMap.forEach((id, movie_title) -> ratingWithTitleMap.put(r.ratingPrediction(userId, id), movie_title));

		Map<Double, String> treeMapForratingWithTitle = new TreeMap<>(ratingWithTitleMap); // sorting movie rating with
																							// title

		System.out.println("Movies in ascending(low to high) order: \n");
		for (Map.Entry<Double, String> entry : treeMapForratingWithTitle.entrySet()) {
			if (entry.getKey() >= 0) {
				System.out.printf("Predicted rating : %.2f for recommended Movie : %s \n\n", entry.getKey(),
						entry.getValue());

			}
		}

	}

}
