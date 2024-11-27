package LLD.Multithreading.PureStorage;

public class Deadlock {
    static class TaskA extends Thread {
        private final Thread threadB;

        TaskA(Thread threadB) {
            this.threadB = threadB;
        }

        @Override
        public void run() {
            try {
                threadB.join(); // A is waiting for B to finish
                System.out.println("Task A completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class TaskB extends Thread {
        private final Thread threadA;

        TaskB(Thread threadA) {
            this.threadA = threadA;
        }

        @Override
        public void run() {
            try {
                threadA.join(); // B is waiting for A to finish
                System.out.println("Task B completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TaskA taskA = new TaskA(Thread.currentThread()); // A waits for main thread (Thread.currentThread)
        TaskB taskB = new TaskB(taskA);  // B waits for TaskA

        taskA.start();
        taskB.start();

        // Deadlock occurs because:
        // - TaskA is waiting for TaskB (via join)
        // - TaskB is waiting for TaskA (via join)
        try {
            taskA.join();
            taskB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

