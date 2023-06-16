import java.util.concurrent.TimeUnit;

public class Days09 {
    public static class T extends Thread {
        @Override
        public void run() {
            while (true) {
                //循环处理业务
                //下面模拟阻塞代码
                try {
                    TimeUnit.SECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    this.interrupt();
                }
                if (this.isInterrupted()) {
                    break;
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
    }


}
