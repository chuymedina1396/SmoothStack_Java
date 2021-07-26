package JavaBasicsFour.src;
public class AssignmentTwo {
 
    //Simple declaration of 2 strings and store them in their memory/variable.
    String stringOne = "Java";
    String stringTwo = "Linux";

    //Thread type: a thread of execution in a program. The Java Virtual Machine allows an application to have multiple threads of execution running concurrently.
     
    Thread threadOne = new Thread("Thread One"){
        public void run(){
            while(true){
                synchronized(stringOne){
                    synchronized(stringTwo){
                        System.out.println(stringOne + stringTwo);
                    }
                }
            }
        }
    };
     
    Thread threadTwo = new Thread("Thread Two"){
        public void run(){
            while(true){
                synchronized(stringTwo){
                    synchronized(stringOne){
                        System.out.println(stringTwo + stringOne);
                    }
                }
            }
        }
    };
     
    public static void main(String [] args){
        AssignmentTwo deadLock = new AssignmentTwo();
        deadLock.threadOne.start();
        deadLock.threadTwo.start();
    }
}