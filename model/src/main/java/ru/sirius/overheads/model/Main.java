/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sirius.overheads.model;

import java.io.File;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import ru.sirius.overheads.model.entity.Article;
import ru.sirius.overheads.model.entity.Delivery;
import ru.sirius.overheads.model.utils.HibernateUtil;

/**
 *
 * @author MorozovIA
 */
public class Main {

    public static void main(String[] args) {
        
        File file = new File("as");
        System.out.println(file.getAbsoluteFile());
        file.delete();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Article> articles = session.createQuery("from Article").list();
        for (Article article : articles) {
            System.out.println(article.getFullName());
        }
//        session.save(new Article(2000, "DDD"));
        Delivery delivery = new Delivery(new Date());
//        delivery.setArticle((Article) session.get(Article.class, new Integer(2000)));
        session.save(delivery);
        session.getTransaction().commit();
    }
}
