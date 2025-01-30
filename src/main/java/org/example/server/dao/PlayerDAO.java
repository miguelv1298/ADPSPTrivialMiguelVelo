package org.example.server.dao;

import jakarta.persistence.Query;
import org.example.cliente.HibernateUtil;
import org.example.server.games.Player;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlayerDAO {

    public static void create(Player player) {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.persist(player);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.err.println("Error Hibernate - " + e.getMessage());
        }
    }

    public static Player find(String name) {
        Player p;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            p = session.find(Player.class, name); // Usar 'name' como parámetro para encontrar el jugador
        }
        return p;
    }

    public static boolean update(Player player) {
        boolean isUpdated = true;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();

            // Usamos merge para actualizar la entidad sin cambiar los campos inmutables
            session.merge(player);  // Esto reemplaza la entidad existente
            session.getTransaction().commit();
            return isUpdated;
        }
        catch (HibernateException e){
            return !isUpdated;
        }
    }

}
