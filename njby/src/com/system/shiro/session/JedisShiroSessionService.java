package com.system.shiro.session;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;

import com.system.shiro.JedisManager;
import com.system.shiro.SerializeUtil;


public class JedisShiroSessionService implements ShiroSessionService{

    private static final String REDIS_SHIRO_SESSION = "shiro-session:";
    private static final int SESSION_VAL_TIME_SPAN = 18000;
    private static final int DB_INDEX = 0;

    private JedisManager jedisManager;
    
	@Override
	public void saveSession(Session session) {
		if (session == null || session.getId() == null) 
			throw new NullPointerException("session is empty"); 
		
        try {
            byte[] key = SerializeUtil.serialize(buildRedisSessionKey(session.getId()));
            byte[] value = SerializeUtil.serialize(session);
            long sessionTimeOut = session.getTimeout() / 1000;
            Long expireTime = sessionTimeOut + SESSION_VAL_TIME_SPAN + (5 * 60);
            jedisManager.saveValueByKey(DB_INDEX, key, value, expireTime.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
	}

	@Override
	public void deleteSession(Serializable sessionId) {
        if (sessionId == null) 
            throw new NullPointerException("session id is empty");
        
        try {
        	jedisManager.deleteByKey(DB_INDEX,
                    SerializeUtil.serialize(buildRedisSessionKey(sessionId)));
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public Session getSession(Serializable sessionId) {
        if (sessionId == null)
            throw new NullPointerException("session id is empty");
        
        Session session = null;
        try {
            byte[] value = jedisManager.getValueByKey(DB_INDEX, SerializeUtil
                    .serialize(buildRedisSessionKey(sessionId)));
            session = SerializeUtil.deserialize(value, Session.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return session;
	}

	@Override
	public Collection<Session> getAllSessions() {
		// TODO Auto-generated method stub
		return null;
	}

    private String buildRedisSessionKey(Serializable sessionId) {
        return REDIS_SHIRO_SESSION + sessionId;
    }

	public JedisManager getJedisManager() {
		return jedisManager;
	}

	public void setJedisManager(JedisManager jedisManager) {
		this.jedisManager = jedisManager;
	}
    
    
    
}
