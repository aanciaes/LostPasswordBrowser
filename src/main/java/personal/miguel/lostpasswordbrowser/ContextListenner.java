/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal.miguel.lostpasswordbrowser;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author miguel
 */
@WebListener
public class ContextListenner implements ServletContextListener {

    private static final Logger log = LogManager.getLogger(ContextListenner.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.debug("Context Initialized");
        HibernateSessionManager.buildSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateSessionManager.closeFactory();        
        
        log.debug("Context Destroyed");
        LogManager.shutdown();
    }
}
