public class Abc {
    private final static Object monitor = new Object();
    private static volatile char indicator = 'C';

    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            synchronized (monitor) {
                for (int i = 0; i < 5; i++) {

                    try {
                        while (indicator != 'C') {
                            monitor.wait();
                        }
                        System.out.print('A');
                        indicator = 'A';
                        monitor.notifyAll();


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        Thread t2 = new Thread(() -> {
            synchronized (monitor) {
                for (int i = 0; i < 5; i++) {

                    try {
                        while (indicator != 'A') {
                            monitor.wait();
                        }
                        System.out.print('B');
                        indicator = 'B';
                        monitor.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        Thread t3 = new Thread(() -> {
            synchronized (monitor) {
                for (int i = 0; i < 5; i++) {

                    try {
                        while (indicator != 'B') {
                            monitor.wait();
                        }
                        System.out.println('C');
                        indicator = 'C';
                        monitor.notifyAll();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        t1.start();
        t2.start();
        t3.start();

    }
}
