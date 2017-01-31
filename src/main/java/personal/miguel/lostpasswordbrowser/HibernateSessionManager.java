/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal.miguel.lostpasswordbrowser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author miguel
 */
public class HibernateSessionManager {

    static final Logger log = LogManager.getLogger(HibernateSessionManager.class);

    private static SessionFactory sessionFactory;

    public static void buildSessionFactory() throws HibernateException {
        if (sessionFactory != null) {
            closeFactory();
        }
        sessionFactory = configureSessionFactory();
    }

    public static Session openSession() throws HibernateException {
        if (sessionFactory == null) {
            buildSessionFactory();
        }
        return sessionFactory.openSession();
    }

    public static void close(Session session) {
        if (session != null) {
            try {
                session.close();
            } catch (HibernateException ignored) {
                log.error("Couldn't close Session", ignored);
            }
        }
    }

    public static void closeFactory() {
        if (sessionFactory != null) {
            try {
                sessionFactory.close();
            } catch (HibernateException ignored) {
                log.error("Couldn't close SessionFactory", ignored);
            }
        }
    }

    private static SessionFactory configureSessionFactory() {
        try {
            //Configures using hibernate.cfg.xml configuration file
            Configuration configuration = new Configuration().configure();

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

            log.debug("Session factory succefully configured");
            return configuration.buildSessionFactory(builder.build());

        } catch (HibernateException ex) {
            log.error("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
