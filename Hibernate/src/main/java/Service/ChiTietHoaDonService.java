package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.ChiTietHoaDonDAO;
import Entity.ChiTietHoaDon;
import Imp.ChitietHoaDonImp;
@Service
public class ChiTietHoaDonService implements ChitietHoaDonImp {
	@Autowired
    ChiTietHoaDonDAO chiTietHoaDonDAO;
	
	public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		return chiTietHoaDonDAO.ThemChiTietHoaDon(chiTietHoaDon);
	}

}
