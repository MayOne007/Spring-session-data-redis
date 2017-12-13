package core.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
public class RedisManagerConfig {
	
	@Autowired
	private RedisConnectionFactory jedisConnectionFactory;
	

	
	@SuppressWarnings("serial")
	@Bean(name="redisCacheManager")
	public RedisCacheManager createCacheManager() {
		Set<String> cacheNames = new HashSet<String>() {{  
	        add("user");
	    }};
		//return RedisCacheManager.create(connectionFactory); //默认管理器
		RedisCacheManagerBuilder builder = RedisCacheManagerBuilder.fromConnectionFactory(jedisConnectionFactory);		
		builder.initialCacheNames(cacheNames); //设置多个缓存
		return builder.build();
	}

}
