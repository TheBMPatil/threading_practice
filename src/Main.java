public class Main {
    public static void main(String[] args) {
        Runnable ob1 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hi ");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread a = new Thread(ob1);
        Thread b = new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                System.out.println("Hello... ");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


//        Thread a = new A();
//        Thread b = new B();
//        a.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Priority of A : " + a.getPriority());
        System.out.println("Priority of B : " + b.getPriority());
        a.start();
        b.start();
    }
}

//class A implements Runnable {
//    //class A extends Thread {
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Hi ");
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}

//class B implements Runnable {
//    //class B extends Thread {
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Hello ");
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}