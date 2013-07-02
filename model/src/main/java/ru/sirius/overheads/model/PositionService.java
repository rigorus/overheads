package ru.sirius.overheads.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ru.sirius.overheads.model.entity.Position;
import ru.sirius.overheads.model.entity.PositionInfo;
import ru.sirius.overheads.model.utils.HibernateUtil;

public class PositionService {

    public static List<Position> getPositions() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();


        session.getTransaction().commit();
        return null;
    }

    //TODO сделать чтоб выгружалось сразу
    public static Position getRootPosition() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Position root;
        List<Position> rootPositions = session.createCriteria(Position.class).add(Restrictions.isNull("parent")).list();
        if (rootPositions.isEmpty()) {
            root = new Position();
            root.setName("Весь список");
            root.setGroup(true);
            root.setBreadthIndex(1);
            root.setDebthIndex(1);
            session.save(root);
        } else {
            // TODO проверка на наличие более чем одного коренного элемента !!!!
            root = rootPositions.get(0);
        }

        session.getTransaction().commit();

        return root;
    }

    public static void addPosition(Position newGroup) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(newGroup);
        
        PositionInfo info = newGroup.getInfo();
        if( info != null){
            info.setId(newGroup.getId());
            session.save(info);
        }
        
        // TODO пересчет индексов !!! группы !!!
        session.getTransaction().commit();
    }
}
