package mega.naemeal.config;

import java.time.Duration;
import java.util.Optional;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisDao {
  private final RedisTemplate<String, Object> redisTemplate;

  public RedisDao(RedisTemplate<String, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public void setValues(String key, Object data) {
    ValueOperations<String, Object> values = redisTemplate.opsForValue();
    values.set(key, data);
  }

  public void setValues(String key, Object data, Duration duration) {
    ValueOperations<String, Object> values = redisTemplate.opsForValue();
    values.set(key, data, duration);
  }

  public Optional<Object> getValues(String key) {
    ValueOperations<String, Object> values = redisTemplate.opsForValue();
    return Optional.ofNullable(values.get(key));
  }

  public void deleteValues(String key) {
    redisTemplate.delete(key);
  }
}