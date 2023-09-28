import java.util.ArrayList;

class PrimeThread1 extends Thread {
    int primeCount = 0;
    ArrayList<Integer> list1 = new ArrayList<>();

    public boolean checkPrimeNumber(int num) {
        if (num <= 1) {
            return false; // 0 and 1 are not prime
        }

        for (int i = 2; i <num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        for (int i = 1000; i < 2000; i++) {
            if (checkPrimeNumber(i)) {
                list1.add(i);
                primeCount++;
                if (primeCount == 12) {
                    for (int j = 0; j < 12; j++) {
                        System.out.print(list1.get(j) + "  ");
                    }
                    System.out.println(); // Move to the next line
                    list1.clear(); // Clear the list
                    primeCount = 0; // reset it
                }
            }
            if (i % 2 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("The thread is interrupted");
                }
            }
        }
    }
}

class PrimeThread2 extends Thread {
    int primeCount = 0;
    ArrayList<Integer> list2 = new ArrayList<>();

    public boolean checkPrimeNumber(int num) {
        if (num <= 1) {
            return false; // 0 and 1 are not prime
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        for (int i = 10000; i < 12000; i++) {
            if (checkPrimeNumber(i)) {
                list2.add(i);
                primeCount++;

                if (primeCount == 12) {
                    for (int k = 0; k < 12; k++) {
                        System.out.print(list2.get(k) + "  ");
                    }
                    System.out.println(); // Move to the next line
                    list2.clear(); // Clear the list
                    primeCount = 0;
                }
            }
            if (i % 2 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("The thread is interrupted");
                }
            }
        }
    }
}

public class MultiThreadedPrimeNumberFinder{
    public static void main(String[] args) {
        System.out.println("Prime numbers between 1k to 2k and 10k to 12k");
        PrimeThread1 th1 = new PrimeThread1();
        th1.start(); // for 1k to 2k
        PrimeThread2 th2 = new PrimeThread2();
        th2.start(); // for 10k to 20k
    }
}
