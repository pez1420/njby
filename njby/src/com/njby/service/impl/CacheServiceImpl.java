package com.njby.service.impl;


import javax.annotation.Resource;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.njby.service.CacheService;
import com.njby.utils.SettingUtils;

import freemarker.template.TemplateModelException;

@Service
public class CacheServiceImpl implements CacheService {
	@Resource(name = "ehCacheManager")
	private CacheManager cacheManager;
	@Resource(name = "messageSource")
	private ReloadableResourceBundleMessageSource messageSource;
	@Resource(name = "freeMarkerConfigurer")
	private FreeMarkerConfigurer freeMarkerConfigurer;

	public String getDiskStorePath() {
		return this.cacheManager.getConfiguration().getDiskStoreConfiguration()
				.getPath();
	}

	public int getCacheSize() {
		int size = 0;
		String[] cacheNames = this.cacheManager.getCacheNames();
		if (cacheNames != null) {
			for (String cacheName : cacheNames) {
				Ehcache ehcache = this.cacheManager.getEhcache(cacheName);
				if (ehcache != null) {
					size += ehcache.getSize();
				}
			}
		}
		return size;
	}

	@CacheEvict(value = { "setting", "logConfig", "template" }, allEntries = true)
	public void clear() {
		this.messageSource.clearCache();
		try {
			this.freeMarkerConfigurer.getConfiguration().setSharedVariable(
					"setting", SettingUtils.get());
		} catch (TemplateModelException e) {
			e.printStackTrace();
		}
		this.freeMarkerConfigurer.getConfiguration().clearTemplateCache();
	}
}
