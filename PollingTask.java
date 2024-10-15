import java.util.Scanner;

public class PollingTask{

	public static void main(String... args){
        	String[] topics = {"Media", "Middle East Uproar", "Inflation", "Empowerment", "Economic Growth"};

        	int[][] responses = new int[topics.length][10];

        	Scanner votes = new Scanner(System.in);
        
        	System.out.print("Enter the number of participants: ");
        	int numberOfParticipants = votes.nextInt();
        
        	for (int index = 0; index < numberOfParticipants; index++) {
            		
			System.out.println("Participant " + (index + 1) + ", please rate the following issues:");

            		for (int checker = 0; checker < topics.length; checker++) {

		               System.out.print("Rate the issue '" + topics[checker] + "' from 1 (Least Important) to 10 (Most Important): ");

				int rating = votes.nextInt();

				while (rating < 1 || rating > 10) {
    					System.out.print("Invalid rating. Please enter a rating from 1 to 10: ");
    					rating = votes.nextInt();
				}

			responses[checker][rating - 1]++;
            }
        }

        processAndDisplayResults(topics, responses);

	}


	public static void processAndDisplayResults(String [] issues, int [][] surveys){
		
		System.out.println("Welcome to the Polling Centre");
		System.out.printf("%20s%-20s%30s", " ", "Least Important", "Most Important");
		System.out.printf("%n%-20s",  "The Issues:");


		for (int columns = 1; columns <= 10; columns++)
			System.out.printf("%-5d", columns);

		System.out.printf("%8s%n", "Average");

		int [] sumTotal = new int [issues.length];
		double average;
		
		
		for (int rowItem = 0; rowItem < issues.length; rowItem++){
			int sumRatings = 0;
			int totalCounts = 0;
			
			for (int columnItem = 0; columnItem < 10; columnItem++){
				sumRatings += ((columnItem + 1) * surveys[rowItem][columnItem]);
				totalCounts += surveys[rowItem][columnItem];
			}
		
		average = (sumRatings * 1.0) / totalCounts;

		sumTotal [rowItem] = sumRatings;
		
		System.out.printf("%-20s", issues[rowItem]);

			for (int check = 0; check < 10; check++){
				System.out.printf("%-5d", surveys[rowItem][check]);	
			}

			System.out.printf("%-8.2f%n", average);
		}

		int highestIndex = 0;
        	int lowestIndex = 0;
       		for (int index = 1; index < sumTotal.length; index++) {
            		if (sumTotal[index] > sumTotal[highestIndex]) {
               			highestIndex = index;
            		}
            		if (sumTotal[index] < sumTotal[lowestIndex]) {
                		lowestIndex = index;
            		}
        	}

        	System.out.printf("%nHighest rated issue: %s with %d points.%n", issues[highestIndex], sumTotal[highestIndex]);
        	System.out.printf("Lowest rated issue: %s with %d points.%n", issues[lowestIndex], sumTotal[lowestIndex]);



	}

}