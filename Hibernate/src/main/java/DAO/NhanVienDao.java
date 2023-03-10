package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Entity.NhanVien;
import Imp.NhanVienImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NhanVienDao implements NhanVienImp {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean KiemTraDangNhap(String email, String matkhau) {
		Session session = sessionFactory.getCurrentSession();
		try {
			NhanVien nhanVien = (NhanVien) session
					.createQuery("from nhanvien where email='" + email + "'and matkhau='" + matkhau + "'")
					.getSingleResult();
			if (nhanVien != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}
     
	@Transactional
	public boolean ThemNhanVien(NhanVien nhanvien) {
		Session session= sessionFactory.getCurrentSession();
		int manhanvien=(Integer) session.save(nhanvien);
		if(manhanvien>0) {
			return true;
		}else {
			return false;
		}
	}

}
