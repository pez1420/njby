package com.njby.service;

public interface CacheService {
	public abstract String getDiskStorePath();

	public abstract int getCacheSize();

	public abstract void clear();
}
