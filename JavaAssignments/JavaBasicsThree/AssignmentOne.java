// Assignment 1

// Write a Java program to get a list of all file/directory names (including in subdirectories) under a given directory. 

//Researched https://www.w3schools.com/java/java_files.asp
// Figured the File object was pretty simple and straight forward for working with files in Java compared to BufferedReader.
import java.io.File; 
  
public class AssignmentOne {
    // Method takes in a File object, and index, and the level
     static void listDirectories(File[] arr, int index, int level) {
         
        //When current index reaching the end of the length of the File array, return.
         if(index == arr.length)
             return;
        
        // IF the current index in the File array is a FILE, THEN print out the name of that file.
         if(arr[index].isFile())
             System.out.println(arr[index].getName());
           
         // ELSE IF, the current index in the File array is a directory, THEN print out the name of the directory.
         else if(arr[index].isDirectory())
         {
             System.out.println("[" + arr[index].getName() + "]");
               
             
             listDirectories(arr[index].listFiles(), 0, level + 1);
         }
            
         listDirectories(arr,++index, level);
    }

    public static void main(String[] args) {
        // Using an ABSOLUTE PATH
        String directory = "C:\\Users\\chuym\\Desktop\\Projects\\java\\SmoothStack_java";
                  
        // Instantiating a new File object and passing the absolute path variable to the File object.
        File currentDir = new File(directory);
           
        // Simple conditional logic to check if the current Directory exists and is indeed a directory
        if(currentDir.exists() && currentDir.isDirectory())
        {
            // File array for files, directories
            File arr[] = currentDir.listFiles();
              
            listDirectories(arr,0,0); 
       } 
    }
}


