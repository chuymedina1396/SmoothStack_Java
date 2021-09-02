public class AssignmentTwo {
    public static void main(String args[])
	{
        int [][] twoDArray = { {1,2,3,4},
                               {5,6,7,8,2121},
                               {9,10,11,12,}
        };
        //Executes the method for finding max value in 2d array
        getMax(twoDArray);
	}
    static void getMax(int[][] twoDArray) {
        int max = twoDArray[0][0];
        int maxIndex = 0;
        for (int j = 0; j < twoDArray.length; j++) {
            for (int i = 0; i < twoDArray[j].length; i++) {
                if (twoDArray[j][i] > max) {
                    max = twoDArray[j][i];
                }
                maxIndex = twoDArray[j][i];
            }
        }
        System.out.println(max);
        System.out.println(maxIndex);
    }
    
}