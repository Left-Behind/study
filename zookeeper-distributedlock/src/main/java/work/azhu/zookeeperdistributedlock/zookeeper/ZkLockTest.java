package work.azhu.zookeeperdistributedlock.zookeeper;

public class ZkLockTest implements Runnable {
    private ZkLock zkLock = new ZkDistributedLock();

    public void run() {
        try {
            if (zkLock.getLock((long)30000,null)) {
                System.out.println("线程:" + Thread.currentThread().getName() + ",抢购成功:" + System.currentTimeMillis());
            } else {
                System.out.println("线程:" + Thread.currentThread().getName() + ",抢购超时失败请重试:" + System.currentTimeMillis());
            }
            //Thread.sleep(1000);
        } catch (Exception e) {

        } finally {
            zkLock.unLock();
        }
    }

    public static void main(String[] args) {
        System.out.println("zk分布式锁开始。。");
        for (int i = 0; i < 100; i++) {
            new Thread(new ZkLockTest()).start();
        }
    }

}