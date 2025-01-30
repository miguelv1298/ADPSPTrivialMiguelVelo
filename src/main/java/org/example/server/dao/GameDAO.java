package org.example.server.dao;

import org.example.cliente.HibernateUtil;
import org.example.server.games.Game;
import org.example.server.games.Player;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class GameDAO {

    public static void create(Game game) {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.persist(game);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.err.println("Error Hibernate - " + e.getMessage());
        }
    }





}
