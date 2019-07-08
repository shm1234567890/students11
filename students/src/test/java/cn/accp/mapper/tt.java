package cn.accp.mapper;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class tt {
    @Test
    public  void test5() {
        Jedis jedis=new Jedis("localhost",6379);
        jedis.set("address","bbb");
    }
}
