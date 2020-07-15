package hino.config;

import static hino.common.Constant.THE_ALMIGHTY_CACHE_KEY;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
@EnableCaching
@Slf4j
public class CacheConfig extends CachingConfigurerSupport {

  /**
   * Make use of {@link CompositeCacheManager} to safeguarding app from cache failure.
   */
  @Bean
  public CacheManager cacheManagers(RedisConnectionFactory redisConnectionFactory) {
    var cacheManager = new CompositeCacheManager(RedisCacheManager.create((redisConnectionFactory)));
    cacheManager.setFallbackToNoOpCache(true);
    return cacheManager;
  }

  /**
   * We should explicitly declare a cache key, or it'd be the default one, let's not use {@link SimpleKeyGenerator}.
   */
  @Bean
  public KeyGenerator keyGenerator() {
    return (target, method, params) -> THE_ALMIGHTY_CACHE_KEY;
  }
}
