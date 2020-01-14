public class Abc {
    public static void main(String[] args){
        Thread t1 = new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
