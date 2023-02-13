package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.NhanVienDao;
import Entity.NhanVien;
import Imp.NhanVienImp;

@Service
public class NhanVienService implements NhanVienImp {
	
    @Autowired
    NhanVienDao nhanVienDao;
	
	public boolean KiemTraDangNhap(String email, String matkhau) {
		boolean kiemtra= nhanVienDao.KiemTraDangNhap(email, matkhau);
		return kiemtra;
	}

	public boolean ThemNhanVien(NhanVien nhanvien) {
		boolean ktthem=nhanVienDao.ThemNhanVien(nhanvien);
		
		return ktthem;
	}
	

}
