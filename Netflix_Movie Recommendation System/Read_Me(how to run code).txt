
Language: JAVA
........................
How to Run the code:

1.In the test class put the file location in filename
in getAllPerson() method put the filename for ratings
in getAllMovie() method put the filename for movie list

3.Run the Main() class to start
If you want to Predict Score Type "P" or want to see recommendation Type "R" : 
Type "E" for Exit
................

Special Issues:
This code has n^3 complexity.
Because of huge number data in the given dataset we would like recommend to use dataset which has data close to 5000 rows.
To help to simulate the code in shorter period I created a shorter version of given Netflix dataset named as
"movies_new.txt" and "rating_new_for_movie.txt" with 4000 data rows.
it creates many blank movies with no ratings as ratings have been given randomly.

Sample input-output given below:
If you want to Predict Score Type "P" or want to see recommendation Type "R" : 
Type "E" for Exit
R
Give User Id for recommendation: 
7
Give Movie year for recommendation: 
2000
Recommended movies are loading..
Movies in ascending(low to high) order: 

Predicted rating : 2.00 for recommended Movie : Brady Bunch Home Movies 

Predicted rating : 3.10 for recommended Movie : George Washington 

Predicted rating : 3.25 for recommended Movie : Wonderland 

Predicted rating : 3.33 for recommended Movie : Songs from the Second Floor 

If you want to Predict Score Type "P" or want to see recommendation Type "R" : 
Type "E" for Exit
P
Give User Id for prediction : 
7
Give Movie Id for prediction: 
1744
Predicted score is loading...
Predicted score by user ID= 7 for movie ID= 1744 : 3.82 

If you want to Predict Score Type "P" or want to see recommendation Type "R" : 
Type "E" for Exit

E
........................

Test With Another Dataset:

To simulate the code in a very small dataset we created an sample dataset named as "created_movie.txt", "created_rating.txt"
where I included 40 movies with 12 users with randomly given rating from 1-5
The dataset format is exactly same as given Netflix dataset format.
If you copy the filename and run with given user id 1-12, movie id 1-40 or movie year 2000-2005 it will give a output like the following

Sample input-output given below:
If you want to Predict Score Type "P" or want to see recommendation Type "R" : 
Type "E" for Exit
P
Give User Id for prediction : 
5
Give Movie Id for prediction: 
20
Predicted score is loading...
Predicted score by user ID= 5 for movie ID= 20 : 2.50 

If you want to Predict Score Type "P" or want to see recommendation Type "R" : 
Type "E" for Exit
R
Give User Id for recommendation: 
5
Give Movie year for recommendation: 
2003
Recommended movies are loading..
Movies in ascending(low to high) order: 

Predicted rating : 1.50 for recommended Movie : Daydream Obsession 

Predicted rating : 2.50 for recommended Movie : Ashtanga Yoga: Beginner's Practice with Nicki Doane 

Predicted rating : 3.50 for recommended Movie : My Favorite Brunette 

Predicted rating : 3.75 for recommended Movie : Dinosaur Planet 

Predicted rating : 4.50 for recommended Movie : Inspector Morse 31: Death Is Now My Neighbour 

If you want to Predict Score Type "P" or want to see recommendation Type "R" : 
Type "E" for Exit
E
