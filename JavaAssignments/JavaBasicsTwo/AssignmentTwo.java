public class AssignmentTwo {
    public static void main(String args[])
	{
        int [][] twoDArray = { {1,2,3,4},
                               {5,6,7,8,2121},
                               {9,10,11,12212},
                               {1000,21212,2321321,321321},
                               {432432432}
                            };
        //Executes the method for finding max value in 2d array
        getMax(twoDArray);
	}
    static void getMax(int[][] twoDArray) {
        int max = twoDArray[0][0];
        int maxIndex1 = -1;
        int maxIndex2 = -1;
        for (int j = 0; j < twoDArray.length; j++) {
            for (int i = 0; i < twoDArray[j].length; i++) {
                if (twoDArray[j][i] > max) {
                    max = twoDArray[j][i];
                    maxIndex1 = i;
                    maxIndex2 = j; 
                }
            }
        }
        System.out.println(max);
        System.out.println("Index Row: " + maxIndex2 + ". Postion: " + maxIndex1);
    }
    
}