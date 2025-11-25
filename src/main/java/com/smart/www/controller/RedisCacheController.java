package com.smart.www.controller;

import com.smart.www.util.RedisCache;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Redis缓存管理控制器
 */
@RestController
@RequestMapping("/api/cache")
@Tag(name = "缓存管理")
public class RedisCacheController {

    @Autowired
    private RedisCache redisCache;

    /**
     * 删除单个缓存
     *
     * @param key 缓存键
     * @return 操作结果
     */
    @DeleteMapping("/delete/{key}")
    public Map<String, Object> deleteCache(@PathVariable String key) {
        Map<String, Object> result = new HashMap<>();
        try {
            boolean success = redisCache.deleteObject(key);
            result.put("success", success);
            result.put("message", success ? "缓存删除成功" : "缓存不存在或删除失败");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "删除失败: " + e.getMessage());
        }
        return result;
    }

    /**
     * 根据模式批量删除缓存
     *
     * @param pattern 匹配模式，例如: "user:*"
     * @return 操作结果
     */
    @DeleteMapping("/deleteByPattern")
    public Map<String, Object> deleteCacheByPattern(@RequestParam String pattern) {
        Map<String, Object> result = new HashMap<>();
        try {
            Collection<String> keys = redisCache.keys(pattern);
            if (keys != null && !keys.isEmpty()) {
                long count = redisCache.deleteObject(keys);
                result.put("success", true);
                result.put("count", count);
                result.put("message", "成功删除 " + count + " 个缓存");
            } else {
                result.put("success", true);
                result.put("count", 0);
                result.put("message", "没有找到匹配的缓存");
            }
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "删除失败: " + e.getMessage());
        }
        return result;
    }

    /**
     * 清空所有缓存（谨慎使用）
     *
     * @return 操作结果
     */
    @DeleteMapping("/clearAll")
    public Map<String, Object> clearAllCache() {
        Map<String, Object> result = new HashMap<>();
        try {
            Collection<String> keys = redisCache.keys("*");
            if (keys != null && !keys.isEmpty()) {
                long count = redisCache.deleteObject(keys);
                result.put("success", true);
                result.put("count", count);
                result.put("message", "成功清空所有缓存，共删除 " + count + " 个");
            } else {
                result.put("success", true);
                result.put("count", 0);
                result.put("message", "缓存已为空");
            }
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "清空失败: " + e.getMessage());
        }
        return result;
    }

    /**
     * 获取所有缓存键
     *
     * @param pattern 匹配模式，默认为 "*"
     * @return 缓存键列表
     */
    @GetMapping("/keys")
    public Map<String, Object> getCacheKeys(@RequestParam(defaultValue = "*") String pattern) {
        Map<String, Object> result = new HashMap<>();
        try {
            Collection<String> keys = redisCache.keys(pattern);
            result.put("success", true);
            result.put("keys", keys);
            result.put("count", keys != null ? keys.size() : 0);
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "获取失败: " + e.getMessage());
        }
        return result;
    }

    /**
     * 删除Hash中的字段
     *
     * @param key   Redis键
     * @param field Hash字段
     * @return 操作结果
     */
    @DeleteMapping("/deleteHashField")
    public Map<String, Object> deleteHashField(@RequestParam String key, @RequestParam String field) {
        Map<String, Object> result = new HashMap<>();
        try {
            redisCache.delCacheMapValue(key, field);
            result.put("success", true);
            result.put("message", "Hash字段删除成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "删除失败: " + e.getMessage());
        }
        return result;
    }
}
