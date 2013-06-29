/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sirius.overheads.model;

import java.io.File;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import ru.sirius.overheads.model.entity.Position;
import ru.sirius.overheads.model.entity.Delivery;
import ru.sirius.overheads.model.utils.HibernateUtil;

/**
 *
 * @author MorozovIA
 */
public class Main {

    public static void main(String[] args) {
        PositionService.getRootPosition();
    }
}
