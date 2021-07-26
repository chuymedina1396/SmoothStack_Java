package JavaBasicsFour.src;
public class AssignmentThree {
    int num;
    public void put(int num){
        System.out.println("Put: " + num);
        this.num = num;
    }
    public void get(){
        System.out.println("Get: " + num);
    }
    public static void main(String[] args){
        AssignmentThree a = new AssignmentThree();
        new Producer(a);
        new Consumer(a);
    }
}

class Producer implements Runnable {
    AssignmentThree a;

    public Producer(AssignmentThree a){
        this.a = a;
        Thread t = new Thread(this, "Producer");
        t.start();
    }
    public void run(){
        int i =0;
        while(true){
            a.put(i++);
            try {
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}

class Consumer implements Runnable {
    AssignmentThree a;
    public Consumer(AssignmentThree a){
        this.a = a;
        Thread t = new Thread(this, "Consumer");
        t.start();
    }

    public void run(){
        while(true){
            a.get();
            try {
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
}
