package nombrePremier;

public class nombrePremier {

    public static void main(String[] args) throws InterruptedException{

        Thread1 th1 = new Thread1();
        Thread2 th2 = new Thread2();

        th1 = new  Thread1();       
        th2 = new Thread2();  
        
        th2.start();    
        th1.start();

        th1.join();    
        th2.join();
    }
}
