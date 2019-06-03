package csw.java.thread;

/*
 java.lang.Thead      
 java中的多线程    类从  Thread  覆盖run方法    调用start启动x线程  
 java中如果线程只剩后台线程那么程序终止运行 setDaemon设置为后台线程     当进城中只剩下后台线程  
 java 中缺省线程优先级是5       MAX_PRIORITY   MINI_PRIORITY   NORM_PRIORITY    10  1   5
 当优先级10的时候线程始终执行 我们可以在线程的任何时候  设置优先级
 另外一种实现多线程的方法是实现 Runable接口   这样的好处是可以共享一个变量 。。
 看下面代码
 */
public class MultiThread {
    public static void main(String[] args) {
        // NewThread nt=new NewThread();
        /*
         * nt.setPriority(Thread.MAX_PRIORITY); //设置最大优先级线程将一直执行 //
         * nt.setDaemon(true);//设置线程为后台线程 如果线程只剩下后台线程那么程序 退出执行 nt.start();//启动线程
         * while(true) System.out.println("main:"+Thread.currentThread().getName());
         */
        // ThreadOne th=new ThreadOne();
        /*
         * new Thread(th).start(); new Thread(th).start(); new Thread(th).start();
         * new Thread(th).start();
         */

        // 内部类实现多线程
        ThreadTwo th = new ThreadTwo();
        th.getInner().start();
        th.getInner().start();
        th.getInner().start();
        th.getInner().start();

    }
}

class NewThread extends Thread // java 中的多线程要从Thread类派生
{
    public void run() // 在我们的线程类中必须覆盖run方法
    {
        while (true) {
            System.out.println(getName());
            // Thread.yield(); //线程暂停执行 对于单CPU可以实现暂停 但是对于多CPU效果就不同了
        }
    }
}

class ThreadOne implements Runnable {
    int index = 0;

    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "+" + index++);
        }
    }
}

// 内部类实现多线程
class ThreadTwo {
    int index = 0;

    private class Inner extends Thread {
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "+" + index++);
            }
        }

    }

    Thread getInner() {
        return new Inner();
    }
}