public class AssignmentTwo {
    public static void main(String args[])
	{
        int [][] twoDArray = { {1,2,3,4},
                               {5,6,7,8,2121},
                               {9,10,11,12,}
        };
        getMax(twoDArray);


        // System.out.println(twoDArray[0][0]);

        // System.out.println("----------------");

        // for( int i =0; i < 3; i++){
        //     System.out.println(twoDArray[i][i]);
        // }

        // System.out.println("----------------");

        // for( int i = 0; i < 3; i++){
        //     for(int j = 0; j < 3; j++){
        //         System.out.println(twoDArray[i][j]);
        //     }
        // }

	}
    static void getMax(int[][] twoDArray) {
        int max = twoDArray[0][0];
        for (int j = 0; j < twoDArray.length; j++) {
            for (int i = 0; i < twoDArray[j].length; i++) {
                if (twoDArray[j][i] > max) {
                    max = twoDArray[j][i];
                }
            }
        }
        System.out.println(max);
    }
    
}