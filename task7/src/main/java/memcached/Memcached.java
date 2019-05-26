package memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

@Component
public class Memcached {
    @Autowired
    MemcachedClient memcachedClient;

    Logger logger=Logger.getLogger(Memcached.class);
    // 更新缓存
    public void setMem(String key, Object value) {
        //exptime 以秒过期时间，0表示没有延迟，如果exptime大于30天，Memcached将使用它作为UNIX时间戳过期。
        int expTime=3600;
        try {
            memcachedClient.set(key, expTime, value);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
    }

    public Object getObj(String s){
        try {
            return  memcachedClient.get(s);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        return  null;
    }

    // 删除缓存
    public void deleteMem(String string) {
        try {
            memcachedClient.delete(string);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
    }



}
