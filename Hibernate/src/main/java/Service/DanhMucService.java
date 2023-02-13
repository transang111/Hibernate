package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.DanhMucDao;
import Entity.DanhMucSanPham;
import Imp.DanhMucIpm;

@Service
public class DanhMucService implements DanhMucIpm{
	@Autowired
	DanhMucDao danhMucDao;

	public List<DanhMucSanPham> listDanhMuc() {
		return danhMucDao.listDanhMuc();
	}

}
