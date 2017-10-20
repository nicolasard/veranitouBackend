package com.veranitou.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
import java.net.URL;

public class HibernateUtil {

    private static final Logger logger = Logger.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            logger.info("Building session factory...");

            // Get the config path from ./resources/
            ClassLoader classLoader = HibernateUtil.class.getClassLoader();
            URL resource = classLoader.getResource("hibernate.cfg.xml");
            logger.info("hibernate.cfg.xml location: "+resource.getPath());
            
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure(resource).buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }

}