package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.HoaDonDAO;
import Entity.HoaDon;
import Imp.HoadonImp;

@Service
public class HoaDonService implements HoadonImp {
	
	 @Autowired
     HoaDonDAO hoaDonDAO;
     
	public int ThemHoaDOn(HoaDon hoaDon) {
		return hoaDonDAO.ThemHoaDOn(hoaDon);
	}
    
}
