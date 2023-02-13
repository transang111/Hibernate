package DAO;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import Entity.HoaDon;
import Imp.HoadonImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HoaDonDAO implements HoadonImp {
	
	@Autowired
	SessionFactory sessionFactory;
     
	@Transactional
	public int ThemHoaDOn(HoaDon hoaDon) {
		Session session= sessionFactory.getCurrentSession();
		int id =(Integer)session.save(hoaDon);
		if(0 < id) {
			return id;
		}else {
		return 0;
		}
	}
   
}
