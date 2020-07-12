package hino.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
@EnableCaching
@Slf4j
public class CacheConfig {

  /**
   * make use of {@link CompositeCacheManager} to safeguarding app from cache failure
   */
  @Bean
  protected CacheManager cacheManagers(RedisConnectionFactory redisConnectionFactory) {
    var cacheManager = new CompositeCacheManager(RedisCacheManager.create((redisConnectionFactory)));
    cacheManager.setFallbackToNoOpCache(true);
    return cacheManager;
  }
}
