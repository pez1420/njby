package com.system.shiro.session;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;

public interface ShiroSessionService {
	
	/***
	 * 更新 session
	 * 
	 * @param session
	 */
    void saveSession(Session session);

    /***
     * 删除session
     * 
     * @param sessionId
     * 			会话Id
     */
    void deleteSession(Serializable sessionId);

    /**
     * 返回
     * @param sessionId  
     * 				会话Id
     * @return
     */
    Session getSession(Serializable sessionId);

    /***
     * 
     * @return
     */
    Collection<Session> getAllSessions();
}
