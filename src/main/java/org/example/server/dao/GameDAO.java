package org.example.server.dao;

import jakarta.persistence.Query;
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

    public static boolean removeAll(Player player) {
        boolean isRemoved = true;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            String hql = "DELETE FROM game;";
            Query query = session.createQuery(hql);
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            return isRemoved;
        }
        catch (HibernateException e){
            return !isRemoved;
        }
    }



}
