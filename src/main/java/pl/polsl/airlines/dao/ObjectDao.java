package pl.polsl.airlines.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ObjectDao {

  protected static SessionFactory getSessionFactory() {
    StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
            .configure("/hibernate.cfg.xml").build();
    Metadata metaData = new MetadataSources(standardRegistry)
            .getMetadataBuilder().build();
    return metaData.getSessionFactoryBuilder().build();
  }
}
