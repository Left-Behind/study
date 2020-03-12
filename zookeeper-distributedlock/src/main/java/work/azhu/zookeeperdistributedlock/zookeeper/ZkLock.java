package work.azhu.zookeeperdistributedlock.zookeeper;

public interface ZkLock {

    // 获取锁
    Boolean getLock(Long acquireTimeout,Long endTime);

    // 释放锁
    void unLock();
}
