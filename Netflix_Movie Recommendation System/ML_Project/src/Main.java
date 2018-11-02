import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); // scanner instance to take inputs

		recommender r = new recommender(); // recommender class instance
		System.out.println("If you want to Predict Score Type \"P\" or want to see recommendation Type \"R\" : ");
		System.out.println("Type \"E\" for Exit");
		String type = s.nextLine(); //input taken
		int user = 0;
		int movie = 0;
		String movie_year = " ";
		while (!type.equalsIgnoreCase("E")) { //loop with stop if user enter E to exit

			if (type.equalsIgnoreCase("P")) { 
				System.out.println("Give User Id for prediction : ");
				user = s.nextInt();
				System.out.println("Give Movie Id for prediction: ");
				movie = s.nextInt();
				System.out.println("Predicted score is loading...");
				System.out.printf("Predicted score by user ID= %d for movie ID= %d : %.2f \n\n", user, movie,
						r.ratingPrediction(user, movie));
				System.out
						.println("If you want to Predict Score Type \"P\" or want to see recommendation Type \"R\" : ");
				System.out.println("Type \"E\" for Exit");

			}
			if (type.equalsIgnoreCase("R")) {
				System.out.println("Give User Id for recommendation: ");
				user = s.nextInt();
				System.out.println("Give Movie year for recommendation: ");
				movie_year = s.next();
				System.out.println("Recommended movies are loading..");
				predictionUsingYear puy = new predictionUsingYear(); // instance class for prection of movie given year
				puy.recommendMovie(user, movie_year); // this method prints out the recommended movie with predicted
														// score in order
				// Given user Id and Movie year
				System.out
						.println("If you want to Predict Score Type \"P\" or want to see recommendation Type \"R\" : ");
				System.out.println("Type \"E\" for Exit");
			}
			type = s.nextLine();

		}

	}

}
