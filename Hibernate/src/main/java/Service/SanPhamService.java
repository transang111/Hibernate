package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.SanPhamDAO;
import Entity.SanPham;
import Imp.SanPhamImp;

@Service
public class SanPhamService implements SanPhamImp {
	@Autowired
	SanPhamDAO sanPhamDAO;

	public List<SanPham> LayDanhSachSanPhamLiMit(int spBatdau) {
		List<SanPham> listsanpham= sanPhamDAO.LayDanhSachSanPhamLiMit(spBatdau);
		return listsanpham;
	}

	public SanPham LayDanhSachChiTietSanPhamTheoMa(int masanpham) {
		return  sanPhamDAO.LayDanhSachChiTietSanPhamTheoMa(masanpham);
	}

	public List<SanPham> LayDanhSachSanPhamTheoMaDanhMuc(int madanhmuc) {
		
		return sanPhamDAO.LayDanhSachSanPhamTheoMaDanhMuc(madanhmuc);
	}

	public boolean XoaSanPhamTheoMaSanPham(int masanpham) {
		return sanPhamDAO.XoaSanPhamTheoMaSanPham(masanpham);
	}

}
