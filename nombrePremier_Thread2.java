package nombrePremier;

public class Thread2 extends Thread{
	static long nextNumber=503;
	static final long max = 1000;
	public static int count=0;
	public long thread = 100;
	public static long[] premier = new long[1000];


	public void run() {
	    long myNumber;
	    while ((myNumber=getNextNumber())<=max) {
	    premier[0] = 503;
	        if (prime(myNumber)) {
	        premier[count++] = myNumber;
	            }
	        }
	    System.out.println("\n-->le nombre des nombres premier entre 500 et 1000 est: "+count);
	    for (int i=0;i<count; i++)
	        System.out.println("thread2 : "+premier[i]+"  ==> temps "+System.currentTimeMillis());
	    }


	public static synchronized long getNextNumber() {
	    long n = nextNumber;
	    nextNumber +=2;
	    return n;
	}

	public boolean prime(long n) {

	    for (int i=2;i<n; i++)
	        if (n%i==0) return false;
	    return true;
	}
}
