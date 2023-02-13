package DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import Entity.DanhMucSanPham;
import Imp.DanhMucIpm;
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucDao implements DanhMucIpm {
	@Autowired
	SessionFactory sessionFactory;
     
	@Transactional
	public List<DanhMucSanPham> listDanhMuc() {
		Session session= sessionFactory.getCurrentSession();
		List<DanhMucSanPham> listDanhMuc=session.createQuery("from danhmucsanpham").getResultList();
		return listDanhMuc;
	}
    
}
