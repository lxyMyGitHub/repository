package cfca.xfraud.api.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.DebugParams;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.Tuple;

public class JedisTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        Jedis jedis = new Jedis("127.0.0.1",6379);
//        List<String> dataList = jedis.lrange("", 0, -1);
//        dataList.size();
//        dataList.get(1);
//        jedis.expire("", 1);
//        Set<Tuple> zset = jedis.zrevrangeWithScores("key11", 0, -1);
//        for (Tuple tuple : zset) {
//            double score = tuple.getScore();
//            String element = tuple.getElement();
//            System.out.println(element+":"+score);
//        }
//        long startTime = System.currentTimeMillis();
//        int i = 0;
//        DebugParams d = null;
//        String cursor = ScanParams.SCAN_POINTER_START;
//        String key ="*";
//        ScanParams scanParams = new ScanParams();
//        scanParams.match(key);
//        scanParams.count(1000);
//        jedis.scan(cursor);
//        int countKeys = 0;
//        Set set = new HashSet();
//        while(true) {
//            ScanResult<String> scanResult = jedis.scan(cursor);
//            cursor = scanResult.getStringCursor();
//            List<String> result = scanResult.getResult();
//            for (String keyName : result) {
//                d = DebugParams.OBJECT(keyName);
//                String debug = jedis.debug(d);
//                System.out.println(debug);
//                long len = getSerializedLength(debug);
//                System.out.println("serializedlength is :"+len);
//            }
//            countKeys += result.size();
//            if("0".equals(cursor)) {
//                break;
//            }
//        }
////        System.out.println(countKeys);
//        String info = jedis.info("keyspace");
//        String[] dbList = info.split(":");
//        String[] messages = dbList[1].split(",");
//        String[] keys = messages[0].split("=");
//        int total = Integer.valueOf(keys[1]);
//        System.out.println("keys="+total);
//        long endTime = System.currentTimeMillis();
//        System.out.println("耗时："+(endTime-startTime)+"ms");
//        long a = getSerializedLength("Value at:498AB560 refcount:1 encoding:raw serializedlength:11 lru:0 lru_seconds_idle:4774371");
//        System.out.println("serializedlength is :"+a);
//        getMemoryRss(jedis);
//        System.out.println(6>'5');
//        System.out.println((int)'5');
        int i = 0;
        for(i=0;i<3;i++) {
            System.out.println(i);
            if(i==2) {
                break;
            }
        }
        System.out.println(i);
    }
    
    private static Long getSerializedLength(String debug) {
        String[] messages = debug.split(" ");
        long length = Long.valueOf(messages[4].split(":")[1]);
        return length;
    }
    
    private static long getMemoryRss(Jedis jedis) {
        String info = jedis.info("Memory");
        String used_memory = info.split("\n")[1];
        System.out.println(used_memory);
        String memory =used_memory.split(":")[1];
        return Long.valueOf(memory.trim());
    }

    
}