/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sirius.overheads.model;

import java.util.List;
import org.hibernate.Session;
import ru.sirius.overheads.model.entity.Article;
import ru.sirius.overheads.model.utils.HibernateUtil;

/**
 *
 * @author MorozovIA
 */
public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Article> articles = session.createQuery("from Article").list();
        for (Article article : articles) {
            System.out.println(article.getFullName());
        }
        session.getTransaction().commit();
    }
}
