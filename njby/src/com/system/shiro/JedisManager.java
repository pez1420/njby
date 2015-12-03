package com.system.shiro;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;


public class JedisManager {

	private JedisPool jedisPool;

	public Jedis getJedis() {
		Jedis jedis = null;

		try {
			jedis = jedisPool.getResource();
		} catch (Exception e) {
			throw new JedisConnectionException(e);
		}
		return jedis;
	}

	public void returnResource(Jedis jedis) {
		if (jedis == null)
			return;
		jedisPool.returnResourceObject(jedis);
	}

	public byte[] getValueByKey(int dbIndex, byte[] key) throws Exception {
		Jedis jedis = null;
		byte[] result = null;

		try {
			jedis = getJedis();
			jedis.select(dbIndex);
			result = jedis.get(key);
		} catch (Exception e) {
			throw e;
		} finally {
			returnResource(jedis);
		}

		return result;
	}

	public void deleteByKey(int dbIndex, byte[] key) throws Exception {
		Jedis jedis = null;

		try {
			jedis = getJedis();
			jedis.select(dbIndex);
			jedis.del(key);
		} catch (Exception e) {
			throw e;
		} finally {
			returnResource(jedis);
		}
	}

	public void saveValueByKey(int dbIndex, byte[] key, byte[] value,
			int expireTime) throws Exception {
		Jedis jedis = null;

		try {
			jedis = getJedis();
			jedis.select(dbIndex);
			jedis.set(key, value);
			if (expireTime > 0)
				jedis.expire(key, expireTime);
		} catch (Exception e) {
			throw e;
		} finally {
			returnResource(jedis);
		}
	}

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	
}
