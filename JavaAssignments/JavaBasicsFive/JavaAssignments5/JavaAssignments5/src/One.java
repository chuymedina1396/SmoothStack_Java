import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class One {
    public static void main(String[] args){
        //1 
        sortArray();
    }

    public static void sortArray(){

        String[] strings = {"Random","Words", "In", "Array", "Hello"};
        // Sorting array of strings from shortest to longest
            Arrays.sort(strings, (a, b) -> {
                return a.length() - b.length();
            });
            Stream.of(Arrays.asList(strings))
                .forEach(System.out::println); //using method references for syntactic sugar.

        // Sorting array of strings from longest to shortest
            Arrays.sort(strings, (a, b) -> {
                return b.length() - a.length();
            });
            Stream.of(Arrays.asList(strings))
                .forEach(System.out::println); 

        // Sorting array alphabetically by the first character only
            Arrays.sort(strings, (a, b) -> {
                return a.charAt(0) - b.charAt(0);
            });
            Stream.of(Arrays.asList(strings))
                .forEach(System.out::println);

        // Filter for strings with 'e' first, everything else second, put code directly in lambda.
             //list words with e first, then list every other strings without e after.
            List<String> list = Arrays.asList(strings);

            // doing the same thing below as above, but more similiar to what I'm familiar to: ES6+ Javascript
            list.stream()
                 .filter((s) -> {
                    return s.contains("e");
                 })
                 .forEach((s) -> {
                     System.out.println(s);
                });          
    } 
}
