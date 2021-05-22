package by.it_academy.jd2.core.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Creates hibernate session using configurations from hibernate.cfg.xml
 * @author Maksim Perekladov
 * @version 0.0
 */

public class HibernateCreator {

    /** Creates SessionFactory object with buildFactory() method */
    private static SessionFactory sessionFactory = buildFactory();

    /** Creates SessionFactory object with hibernate.cfg.xml configurations.
     * @return SessionFactory.
     */
    private static SessionFactory buildFactory(){
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();

            Metadata metadata = new MetadataSources(serviceRegistry)
                    .getMetadataBuilder()
                    .build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable t){
            throw new RuntimeException(t);
        }
    }

    /** Creates one sessionFactory object for all classes.
     * @return sessionFactory object
     */
    public static SessionFactory getInstance(){
        return sessionFactory;
    }
}
