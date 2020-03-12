package work.azhu.zookeeperdistributedlock.zookeeper;


import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

public class ZkDistributedLock implements ZkLock {
    // 集群连接地址
    private String CONNECTION = "www.azhu.work:2181";
    // zk客户端连接
    private ZkClient zkClient = new ZkClient(CONNECTION);
    // path路径
    private String lockPath = "/lock";
    private CountDownLatch countDownLatch;
    //请求设置的超时时间：acquireTimeout 毫秒。最终超时时间endTime
    public Boolean getLock(Long acquireTimeout,Long endTime) {
        Boolean lock = false;
        if (endTime == null) {
            //等待超时时间
            endTime = System.currentTimeMillis() + acquireTimeout;
        }
        if (tryLock()) {
            System.out.println("####获取锁成功######");
            lock = true;
        } else {
            if (waitLock(endTime)) {
                if (getLock(null,endTime)) {
                    lock = true;
                }
            }
        }
        return lock;
    }

    public void unLock() {
        if (zkClient != null) {
            System.out.println("#######释放锁#########");
            zkClient.close();
        }
    }

    private boolean tryLock() {
        try {
            zkClient.createEphemeral(lockPath);
            return true;
        } catch (Exception e) {

            return false;
        }

    }

    private Boolean waitLock(Long endTime) {
        // System.out.println("进入等待");
        // 使用zk临时事件监听
        IZkDataListener iZkDataListener = null;
        try {
            // 使用zk临时事件监听
            iZkDataListener = new IZkDataListener() {

                public void handleDataDeleted(String path) throws Exception {
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }
                public void handleDataChange(String arg0, Object arg1) throws Exception {

                }
            };
            // 注册事件通知
            zkClient.subscribeDataChanges(lockPath, iZkDataListener);
            if (System.currentTimeMillis() < endTime) {
                if (zkClient.exists(lockPath)) {
                    countDownLatch = new CountDownLatch(1);
                    try {
                        countDownLatch.await();
                        return true;
                    } catch (Exception e) {

                    }
                } else {
                    return true;
                }
            } else {
                System.out.println("超时返回");
            }
        } catch (Exception e) {

        } finally {
            // 监听完毕后，移除事件通知
            zkClient.unsubscribeDataChanges(lockPath, iZkDataListener);
        }
        return false;
    }

}