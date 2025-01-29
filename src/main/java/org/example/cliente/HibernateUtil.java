package org.example.cliente;

import java.util.Properties;
import org.example.server.games.Game;
import org.example.server.games.Player;
import org.example.server.questions.Answer;
import org.example.server.questions.Category;
import org.example.server.questions.Question;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration config = new Configuration();
            Properties properties = new Properties();

            properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            // Conexión JDBC a la BD: jdbc:mysql://[servidor]:[puerto]/[base_de_datos]
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatedb");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "root");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            properties.put(Environment.HBM2DDL_AUTO, "create-drop");

            config.setProperties(properties);

            // A continuación indicamos las clases mapeadas con etiquetas o los ficheros xml de mapeo
            config.addAnnotatedClass(Game.class);
            config.addAnnotatedClass(Player.class);
            config.addAnnotatedClass(Category.class);
            config.addAnnotatedClass(Question.class);
            config.addAnnotatedClass(Answer.class);


            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(config.getProperties())
                    .build();

            sessionFactory = config.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}
