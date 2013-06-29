package ru.sirius.overheads.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ru.sirius.overheads.model.entity.Position;
import ru.sirius.overheads.model.utils.HibernateUtil;


public class PositionService {

    public static List<Position> getPositions(){        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        
        session.getTransaction().commit();
        return null;
    }

    //TODO сделать чтоб выгружалось сразу
    public static Position getRootPosition() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        List<Position> root = session.createCriteria(Position.class).add(Restrictions.isNull("parent")).list();
        if( root.isEmpty()){
            root = new Position();            
            
        }
        
        session.getTransaction().commit();
        
        return root != null && root.size() == 1 ? root.get(0) : null;
    }

}
