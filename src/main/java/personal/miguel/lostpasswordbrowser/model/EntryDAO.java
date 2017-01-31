/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal.miguel.lostpasswordbrowser.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import personal.miguel.lostpasswordbrowser.HibernateSessionManager;

/**
 *
 * @author miguel
 */
public class EntryDAO {

    static final String DATEPATTERN = "yyyy-MM-dd";
    static Logger log = LogManager.getLogger(EntryDAO.class);

    public EntryDAO() {
        ;
    }

    public List getEntryByCriteria(String userId, String ticket, String email, String initDate, String finalDate) {
        Session hbSession = null;
        try {
            hbSession = HibernateSessionManager.openSession();

            Criteria criteria = hbSession.createCriteria(Entry.class);

            if (!userId.equals("")) {
                criteria.add(Restrictions.like("userId", "%" + userId + "%"));
            }

            if (!ticket.equals("")) {
                criteria.add(Restrictions.like("ticket", "%" + ticket + "%"));
            }

            if (!email.equals("")) {
                criteria.add(Restrictions.like("email", "%" + email + "%"));
            }

            SimpleDateFormat sdf = new SimpleDateFormat();
            sdf.applyPattern(DATEPATTERN);

            if (!initDate.equals("")) {
                Date init = sdf.parse(initDate);
                criteria.add(Restrictions.gt("timestamp", init));
            }

            if (!finalDate.equals("")) {
                Date finalD = sdf.parse(finalDate);
                criteria.add(Restrictions.le("timestamp", finalD));
            }

            return criteria.list();
        
        } catch (ParseException | HibernateException ex) {
            log.error(ex.toString());
            return null;
        }finally {
            HibernateSessionManager.close(hbSession);
        }
    }
}
