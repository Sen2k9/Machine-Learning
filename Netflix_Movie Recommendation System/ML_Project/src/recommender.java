import java.util.ArrayList;

public class recommender {
	public void init() {

	}

	public double ratingPrediction(int activeuser_id, int movie) { // method to predict rating given user id and movie id

		ArrayList<Person> neighbourhood = findNeighbour(activeuser_id, 2);
		double prediction = predictionFromNeighbour(neighbourhood, movie);
		return prediction;

	}

	private double predictionFromNeighbour(ArrayList<Person> neighbourhood, int movie) { // method to create
																									// prediction from
																									// the active user k
																									// neighbours
		double sum = 0;
		int totalNumber = 0;
		for (Person n : neighbourhood) {
			if (n.hasRated(movie)) {

				sum += n.getRating(movie);
				totalNumber++;

			}
		}

		return sum / totalNumber;
	}

	private ArrayList<Person> findNeighbour(int activeuser_id, double k) {// method to return neighbourhood of the
																				// given active user
		ArrayList<Person> neighbourhood = new ArrayList<Person>();
		test tester = new test();

		for (Person otheruser : tester.getAllPerson()) {

			if (otheruser.getID() != activeuser_id) {
				double similarity = measureSimilarity(activeuser_id, otheruser);
				if (similarity < k) {

					neighbourhood.add(otheruser);

				}

			}
		}

		return neighbourhood;
	}

	private double measureSimilarity(int activeuser_id, Person otheruser) {// method to calculate similarity with
																				// active user and all other created
																				// person
		int common_movie = 0;
		double difference_Sum = 0;
		test tester = new test();
		for (Person activeuser : tester.getAllPerson()) {
			if (activeuser.getAllRatingsGivenId(activeuser_id) != null) {

				for (Double r1 : activeuser.getAllRatingsGivenId(activeuser_id)) {
					for (Double r2 : otheruser.getAllRatings()) {
						int m1 = activeuser.getMovie(r1);
						int m2 = otheruser.getMovie(r2);
						if (m1 == m2) {
							common_movie++;
							difference_Sum += Math.abs(r1 - r2);

						}
					}

				}

			}
		}
		if (common_movie > 0) {
			return difference_Sum / common_movie;
		}
		return Integer.MAX_VALUE; // return very large value to indicate no simmilarity
	}

}
