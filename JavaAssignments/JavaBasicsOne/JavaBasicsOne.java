// package JavaAssignments; // Getting error for package for some weird reason. Will investigate later
/**
 * @author chuymedina9613 
 */
public class JavaBasicsOne {
    // First Pattern: 
	static void printRows(int rows){
        // loop handles looping through the number of rows given by user(or hardcoded in variable in this case)
        for(int i=0; i<rows; i++){
            for(int j=0; j<=i; j++){
                // print stars FOR as long as j is less than or equal to i
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    //Second Pattern:
    static void printRowsDownUp(int rows){
        for(int i=0; i<rows; i++){
            for(int j=rows-1; j>i; j--){
                // print stars FOR as long as j is less than or equal to i
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //Third Pattern:
    static void printPyramid(int rows){
        for (int i=0; i<rows; i++) {
            for (int j=rows-i; j>1; j--) {
                System.out.print(" ");
            }
            for (int j=0; j<=i; j++ ) {
                // printing stars
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    //Fouth Pattern:
    static void printPyramidUpDown(int rows){
        //Printing the pattern
        for (int i = 1; i <= rows; i++){
          for (int j = 1; j < i; j++){
                System.out.print(" ");
            }
          for (int j = i; j <= rows; j++){
                System.out.print("* ");
            }  
            System.out.println();
        }
    }
     

    // Main method(entry point to any java program.)
	public static void main(String args[])
	{
		int rows = 4;
        // 1)
		printRows(rows);
        // 2)
        printRowsDownUp(rows);
        // 3)
        printPyramid(rows);
        // 4)
        printPyramidUpDown(rows);

	}
}
