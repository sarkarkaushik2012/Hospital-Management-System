package com.java.hib;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

public class SubscribeDataImpl {

	SessionFactory sf;
	Session session;

	
	public int countRows() {
			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			try {
				session.beginTransaction();
				Criteria criteria = session.createCriteria(Subscriptions.class);
				if (criteria != null) {
					return criteria.list().size();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}
	public List<Subscriptions> getListofSubsData(int firstRow, int rowCount) {
		JsfPaginationBeanSubs subs = new JsfPaginationBeanSubs();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		List<Insurance_Details> cdList = null;
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Subscriptions.class);
		subs.handlingPlanSort(criteria);
		criteria.setFirstResult(firstRow);
		criteria.setMaxResults(rowCount);
		return criteria.list();
	}
}
