public class SignalThreadDemo {
    public static void main(String[] args) {
        Thread signalThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 'Signal' is running...");
            }
        });

        signalThread.setName("Signal");
        signalThread.setPriority(Thread.MAX_PRIORITY);
        signalThread.start();

        System.out.println("Thread Name: " + signalThread.getName());
        System.out.println("Thread Priority: " + signalThread.getPriority());
    }
}
