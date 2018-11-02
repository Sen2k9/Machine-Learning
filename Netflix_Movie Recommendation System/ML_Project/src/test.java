import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/*
 * class to read data from dataset
 * getAllMovie() method work on movie_titles.txt dataset
 * getAllPerson() method work on ratings.txt dataset
 */
public class test {

	public LinkedList<Movie> getAllMovie() {

		Scanner s = null; // to scan data
		String fileName = "G:\\PhD courses\\COMP 8745(Machine_Learning)\\project\\project\\netflix\\movies_new.txt";
		LinkedList<Movie> movielist = new LinkedList<>();// storing movie data in a list

		try { // If file does not exit
			s = new Scanner(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("test.getAllMovie: could not open file " + fileName + ".");

		}

		while (s.hasNext()) { // For each item in the file...
			String nextItem = s.nextLine();

			int i, j;

			// Find the first ',' split the string after that
			for (i = 0; nextItem.charAt(i) != ','; i++)
				;
			String movieId = nextItem.substring(0, i);
			int movie_Id = Integer.parseInt(movieId);
			String yearandtitle = nextItem.substring(i + 1);

			// Find next ',' split the string after that
			for (j = 0; yearandtitle.charAt(j) != ','; j++)
				;
			String yearS = yearandtitle.substring(0, j);
			// int year= Integer.parseInt(yearS);

			String title = yearandtitle.substring(j + 1);
			Movie newmovie = new Movie(title, yearS, movie_Id);
			movielist.add(newmovie); // store all movie data to movielist

		} // end while (s.hasNext())

		s.close();// close file

		return movielist;

	}

	public LinkedList<Person> getAllPerson() {

		ArrayList<Integer> idcheck = new ArrayList<>(); // store user id one by one in a arraylist to remove duplicate
														// id
		Scanner s1 = null;
		String fileName2 = "G:\\PhD courses\\COMP 8745(Machine_Learning)\\project\\project\\netflix\\rating_new_for_movie.txt";
		LinkedList<Person> personlist = new LinkedList<>(); // store all Person in a list

		try { // if file is not found
			s1 = new Scanner(new FileReader(fileName2));
		} catch (FileNotFoundException e) {
			System.out.println("test.getAllPerson: could not open file " + fileName2 + ".");

		}

		while (s1.hasNext()) { // if the file contains any string
			String nextItem = s1.nextLine(); // Take the next line
			int i = 0;
			int j = 0;
			int user_id1 = 0;

			// Find the first ',' split the string after that
			for (i = 0; nextItem.charAt(i) != ','; i++)
				;
			String movieId2 = nextItem.substring(0, i);
			int movie_Id2 = Integer.parseInt(movieId2);

			String userIdandRating1 = nextItem.substring(i + 1);

			// Find the first ',' split the string after that
			for (j = 0; userIdandRating1.charAt(j) != ','; j++)
				;
			String userId1 = userIdandRating1.substring(0, j);
			user_id1 = Integer.parseInt(userId1);

			String rating1 = userIdandRating1.substring(j + 1);
			double ratings1 = Double.parseDouble(rating1);

			if (!idcheck.contains(user_id1)) { // if the current user Id is taken for the first time
				idcheck.add(user_id1); // store the id in the arraylist
				Map<Integer, Double> moviewithrating = new HashMap<>(); // haspMap for storing movie id and rating
				moviewithrating.put(movie_Id2, ratings1);
				Person thisperson = new Person(user_id1, moviewithrating); // store the data for a person class
				personlist.add(thisperson);
			} else { // If the current user Id is already taken

				Person thisperson2 = null;

				for (Person p : personlist) {
					if (p.getID() == user_id1) {
						thisperson2 = p.getPerson(user_id1);
						break;
					}
				}
				thisperson2.setMoviewithRating(movie_Id2, ratings1);

			}

		} // end while (s1.hasNext())

		s1.close(); // close file

		return personlist;// return list of all person from datafile
	}
}
