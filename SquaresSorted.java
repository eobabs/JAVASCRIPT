import java.util.*;

public class SquaresSorted{

	public static void main(String... args){

		int [] number = {2, 1, 4, 3, 5, 9};

		sortedArrays(number);
	

	}


	public static int [] sortedArrays(int [] arrays){

		for (int index = 0; index < arrays.length; index++){
			for (int checker = 0; checker < arrays.length - index - 1; checker++){			
				if (arrays[checker] > arrays[checker + 1]){
					arrays[checker] = arrays[checker] + arrays[checker + 1];
					arrays[checker + 1] = arrays[checker] - arrays[checker + 1];
					arrays[checker] = arrays[checker] - arrays[checker + 1];
				}
			}
				
		}

			

		for (int count = 0; count < arrays.length; count++){

			arrays [count] = arrays [count] * arrays [count];
		}
		System.out.print("The squares of the original array is: " + Arrays.toString(arrays));

		return arrays;
	}

	
	
}