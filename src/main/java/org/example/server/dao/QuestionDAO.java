package org.example.server.dao;

import org.example.cliente.HibernateUtil;
import org.example.server.questions.Question;
import org.hibernate.Session;
import java.util.List;

public class QuestionDAO {

    public static List<Question> getSixRandomQuestions() {
        List<Question> questions = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            questions = session.createQuery("FROM Question ORDER BY RAND()", Question.class)
                    .setMaxResults(6)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }
}
