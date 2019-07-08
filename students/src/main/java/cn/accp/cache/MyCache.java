package cn.accp.cache;

import cn.accp.util.SerializeUtil;
import org.apache.ibatis.cache.Cache;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCache implements Cache {
    //jedis是Java连接Redis的数据库驱动
    private static Jedis jedis=new Jedis();
    //mybatis的硬性要求，必须有string的id
    private final String id;
    //保证多人使用缓存的时候是线程安全的
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    //mybatis的硬性要求
    public MyCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object o, Object o1) {
        Lock lock = readWriteLock.writeLock();
        try{
            lock.lock();
            jedis.set(SerializeUtil.serialize(o), SerializeUtil.serialize(o1));
        } finally {
            lock.unlock();
        }

    }

    @Override
    public Object getObject(Object o) {
        return SerializeUtil.deserialize(jedis.get(SerializeUtil.serialize(o)));

    }

    @Override
    public Object removeObject(Object o) {
        return jedis.expire(SerializeUtil.serialize(o), 0);
    }

    @Override
    public void clear() {//清空二级缓存
        jedis.flushAll();//清空redis数据库

    }

    @Override
    public int getSize() {//查看二级缓存的大小
        Lock lock=readWriteLock.writeLock();
        try {
            lock.lock();
            return  jedis.dbSize().intValue();
        }finally {
            lock.unlock();
        }


    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }
}
