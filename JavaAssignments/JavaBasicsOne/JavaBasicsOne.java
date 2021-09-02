// Corrected my solution for last time. 
/**
 * @author chuymedina9613 
 */
public class JavaBasicsOne {
     // Main method(entry point to any java program.)
    public static void main(String args[])
	{
        //Declared one variable for input into the method above.
		int rows = 4;
        int rowsTwo = 5;
        // 1)
        System.out.println("1)");
		printRows(rows);
        System.out.println(" ");
        System.out.println("2)");
        // 2)
        printRowsDownUp(rowsTwo);
        // 3)
        System.out.println("3)");
        printPyramid(rows);
        // 4)
        System.out.println("4)");
        printPyramidUpDown(rows);

	}
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
        for(int i=0; i<9; i++){
            System.out.print(".");
        }
    }
    //Second Pattern:
    static void printRowsDownUp(int rows){
        for(int i=0; i<10; i++){
            System.out.print(".");
        }
        System.out.println(" ");
        for(int i=0; i<rows; i++){
            for(int j=rows-1; j>i; j--){
                // print stars FOR as long as j is less than or equal to i
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    // Getting the dots right was tricky, so I just used stars.
    //Third Pattern:
    static void printPyramid(int rows){
        for (int i=1; i <= rows; i++) {
            
            for(int j=1; j <= rows-i; j++)
            System.out.print(" ");
   
            for(int k=1; k <= (2*i-1); k++)
            System.out.print("*");
   
            System.out.println();
         }
    }
    //Fouth Pattern:
    static void printPyramidUpDown(int rows){
        for (int i=1; i <= rows; i++) {
            for(int j=1; j < 2*rows; j++)
            if(j < i){
                System.out.print(" "); 
            }
            else if(j <= 2*rows-i){
                System.out.print("*"); 
            }
            System.out.println();
         }
    }
}
