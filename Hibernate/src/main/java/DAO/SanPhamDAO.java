package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import Entity.SanPham;
import Imp.SanPhamImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamImp{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<SanPham> LayDanhSachSanPhamLiMit(int spBatdau) {
		Session session=sessionFactory.getCurrentSession();
		List<SanPham> listsanPham= new ArrayList<SanPham>();
		if(spBatdau<0) {
			String sql="from sanpham";
	    	 listsanPham= session.createQuery(sql).getResultList();
		}else {
			 listsanPham=(List<SanPham>) session.createQuery("from sanpham").setFirstResult(spBatdau).setMaxResults(5).getResultList();
		}
		return listsanPham;
	}

    @Transactional
	public SanPham LayDanhSachChiTietSanPhamTheoMa(int masanpham) {
    	Session session=sessionFactory.getCurrentSession();
    	String sql="from sanpham sp where sp.masanpham="+masanpham;
    	SanPham sanpham= (SanPham) session.createQuery(sql).getSingleResult();
		return sanpham;
	}
    @Transactional
	public List<SanPham> LayDanhSachSanPhamTheoMaDanhMuc(int madanhmuc) {
		Session session=sessionFactory.getCurrentSession();
    	String sql="from sanpham sp where sp.danhmucsanpham.madanhmuc="+madanhmuc;
    	List<SanPham> listsanPham= session.createQuery(sql).getResultList();
		return listsanPham;
	}
     
    @Transactional
	public boolean XoaSanPhamTheoMaSanPham(int masanpham) {
		Session session=sessionFactory.getCurrentSession();
		SanPham sanPham= session.get(SanPham.class, masanpham);
		session.delete(sanPham);
		return false;
	}
    
}
