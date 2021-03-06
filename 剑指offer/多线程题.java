import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        NumClass num = new NumClass();
        printEven even = new printEven(num);
        printOdd odd = new printOdd(num);
        PrintA printA = new PrintA(num);
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(even);
        executor.execute(odd);
        executor.execute(printA);
        executor.shutdown();
    }

    private static class NumClass {
        int num = 0;
        int flag = 0;
        String eng = "A";

    }

    private static class printEven implements Runnable {

        NumClass numClass;

        public printEven(NumClass numClass) {
            this.numClass = numClass;
        }

        @Override
        public void run() {
            while (numClass.num <= 8) {
                synchronized(numClass) {

                    if (numClass.flag == 0) {
                        for (int i = 1; i <= 5; i++) {
                            System.out.println("A线程执行第 " + i + " 次！");
                        }
                        numClass.num++;
                        numClass.flag = 1;
                        numClass.notifyAll();
                    } else {
                        try {
                            numClass.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
    }


    private static class printOdd implements Runnable {
        NumClass numClass;

        public printOdd(NumClass numClass) {
            this.numClass = numClass;
        }

        @Override
        public void run() {
            while (numClass.num <= 8) {
                synchronized(numClass) {
                    if (numClass.flag == 1) {
                        for (int i = 1; i <= 10; i++) {
                            System.out.println("B线程执行第 " + i + " 次！");
                        }
                        numClass.num++;
                        numClass.flag = 2;
                        numClass.notifyAll();
                    } else {
                        try {
                            numClass.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


    private static class PrintA implements Runnable {
        NumClass numClass;

        public PrintA(NumClass numClass) {
            this.numClass = numClass;
        }

        @Override
        public void run() {
            while (numClass.num <= 8) {
                synchronized(numClass) {
                    if (numClass.flag == 2) {
                        for (int i = 1; i <= 15; i++) {
                            System.out.println("C线程执行第 " + i + " 次！");
                        }
                        numClass.num++;
                        numClass.flag = 0;
                        numClass.notifyAll();
                    } else {
                        try {
                            numClass.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


}
