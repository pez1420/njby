package com.system.shiro.listener;


import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;


import com.system.shiro.session.ShiroSessionService;


/**
 * 会话监听器
 * 
 * @author Administrator
 *
 */
public class CustomSessionListener implements SessionListener {


    private ShiroSessionService shiroSessionService;

    @Override
    public void onStart(Session session) {
        //TODO
        System.out.println("on start");
    }

    @Override
    public void onStop(Session session) {
        //TODO
        System.out.println("on stop");
    }

    @Override
    public void onExpiration(Session session) {
    	shiroSessionService.deleteSession(session.getId());
    }

	public ShiroSessionService getShiroSessionService() {
		return shiroSessionService;
	}

	public void setShiroSessionService(ShiroSessionService shiroSessionService) {
		this.shiroSessionService = shiroSessionService;
	}

    

}
