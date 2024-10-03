import java.util.*;

public class ReverseString {

    	public static void main(String[] args) {

		returnReverse("We are happy");
	}

	public static String returnReverse(String textTest){

		Scanner input = new Scanner(System.in);

		String [] arrayReverse = textTest.split(" ");

		String tester = " ";

		for (int index = 0; index < arrayReverse.length; index++)
			tester = arrayReverse[index] + " " + tester;

        
            System.out.println("reversed sentence: " + tester );
		return tester;
    }
}
