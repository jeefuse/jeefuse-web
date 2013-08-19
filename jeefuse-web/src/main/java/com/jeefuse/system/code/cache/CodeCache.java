package com.jeefuse.system.code.cache;

import java.net.URL;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeefuse.base.modules.cache.CacheManagerable;
import com.jeefuse.base.modules.cache.Cacheable;
import com.jeefuse.system.code.model.GsysCode;
import com.jeefuse.system.code.service.CodeServiceFactory;

/**
 * 编码缓存.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class CodeCache implements Cacheable<GsysCode>, CacheManagerable {
	private static final Logger logger = LoggerFactory.getLogger(CodeCache.class);
	public static final String CACHE_NAME = "codeCache";
	private static CodeCache instance;
	private CacheManager cacheManager;

	private CodeCache() {
		logger.info("创建编码数据缓存...");
		URL url = getClass().getResource("/ehcache/ehcache-code.xml");
		cacheManager = new CacheManager(url);
		initCache();
		logger.info("创建编码数据缓存完成!");
	}

	private static synchronized void syncInit() {
		if (instance == null) {
			instance = new CodeCache();
		}
	}

	/**
	 * 获取实例.
	 */
	public static CodeCache getInstance() {
		if (instance == null) {
			syncInit();
		}
		return instance;
	}

	/**
	 * 初始化缓存.
	 */
	private void initCache() {
		List<GsysCode> list = CodeServiceFactory.getGsysCodeService().getAllAndCodeValue();
		if (null != list) {
			Cache cache = getCache();
			for (GsysCode item : list) {
				cache.put(new Element(item.getCid(), item));
			}
		}
	}

	/**
	 * 获取缓存管理类
	 * 
	 * @return 缓存管理类
	 */
	public CacheManager getCacheManager() {
		return cacheManager;
	}

	/**
	 * 获取缓存
	 * 
	 * @return 缓存
	 */
	public Cache getCache() {
		return getCacheManager().getCache(CACHE_NAME);
	}

	/**
	 * 添加缓存对象
	 * 
	 * @param key
	 *            缓存KEY
	 * @param cacheObj
	 *            缓存对象
	 */
	public void put(final String key, GsysCode obj) {
		getCache().put(new Element(key, obj));
		if (logger.isDebugEnabled()) {
			logger.debug("添加KEY为{}的缓存对象,当前缓存{}个", key, getCache().getSize());
		}
	}

	/**
	 * 获取缓存对象
	 * 
	 * @param key
	 *            缓存KEY
	 * @return 缓存对象
	 */
	public GsysCode get(final String key) {

		Element element = getCache().get(key);
		if (logger.isDebugEnabled()) {
			logger.debug("获取KEY为{}的缓存对象", key);
		}
		if (element == null)
			return null;
		return (GsysCode) element.getValue();
	}

	/**
	 * 移除指定KEY缓存对象
	 * 
	 * @param key
	 *            缓存KEY
	 */
	public void remove(final String key) {
		if (get(key) != null) {
			getCache().remove(key);
			if (logger.isDebugEnabled()) {
				logger.debug("移除取KEY为{}的缓存对象", key);
			}
		}
	}

	public void destroyCache() {
		cacheManager.clearAll();
	}

	public void refreshCache() {
		cacheManager.clearAll();
		initCache();
	}
}
