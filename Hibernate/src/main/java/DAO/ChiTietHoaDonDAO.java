package DAO;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import Entity.ChiTietHoaDon;
import Entity.ChiTietHoaDonId;
import Imp.ChitietHoaDonImp;
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonDAO implements ChitietHoaDonImp {
    @Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		Session session= sessionFactory.getCurrentSession();
		ChiTietHoaDonId id=(ChiTietHoaDonId)session.save(chiTietHoaDon);
		if(id!=null) {
			return true;
		}else {
			return false;
		}
	}

}
