package com.gdufs.redis;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author gucailiang
 * @date 2018/9/30
 */
@Configuration
@EnableCaching
@EnableRedisHttpSession
public class CacheConfig extends CachingConfigurerSupport {

    /**
     * Spring 3.1内置了五个缓存管理器实现，如下所示：
     * SimpleCacheManager
     * NoOpCacheManager
     * ConcurrentMapCacheManager
     * CompositeCacheManager
     * EhCacheCacheManager
     * <p>
     * Spring 3.2引入了另外一个缓存管理器，这个管理器可以用在基于JCache（JSR-107）的缓存提供商之中。除了核心的Spring框架，Spring Data又提供了两个缓存管理器：
     * RedisCacheManager（来自于Spring Data Redis项目）
     * GemfireCacheManager（来自于Spring Data GemFire项目）
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
        //使用前缀
        rcm.setUsePrefix(true);
        //缓存分割符 默认为 ":"
//        rcm.setCachePrefix(new DefaultRedisCachePrefix(":"));
        //设置缓存过期时间
        //rcm.setDefaultExpiration(60);//秒
        return rcm;
    }
}
