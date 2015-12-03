package com.system.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

import java.io.Serializable;
import java.util.Collection;



public class CustomShiroSessionDAO extends AbstractSessionDAO {

    private ShiroSessionService shiroSessionService;

    @Override
    public void update(Session session) throws UnknownSessionException {
        System.out.println("update session");
        shiroSessionService.saveSession(session);
    }

    @Override
    public void delete(Session session) {
        if (session == null) {
            return;
        }
        Serializable id = session.getId();
        if (id != null) {
            System.out.println("delete session");
            shiroSessionService.deleteSession(id);
        }
        //TODO if session is too large,when session destory clear shiro cache
    }

    @Override
    public Collection<Session> getActiveSessions() {
        System.out.println("get active sessions");
        return shiroSessionService.getAllSessions();
    }

    @Override
    protected Serializable doCreate(Session session) {
        System.out.println("do create session");
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        shiroSessionService.saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        System.out.println("do read session");
        return shiroSessionService.getSession(sessionId);
    }

	public ShiroSessionService getShiroSessionService() {
		return shiroSessionService;
	}

	public void setShiroSessionService(ShiroSessionService shiroSessionService) {
		this.shiroSessionService = shiroSessionService;
	}


}
