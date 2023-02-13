package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Entity.DanhMucSanPham;
import Entity.SanPham;
import Service.DanhMucService;
import Service.SanPhamService;

@Controller
@RequestMapping("/themsanpham")
public class ThemSanPhamController {
	@Autowired
     SanPhamService sanPhamService;
	@Autowired
	DanhMucService danhMucService;
	@GetMapping
	public String Defaul(ModelMap modelMap) {
	List<SanPham> listSanPham=sanPhamService.LayDanhSachSanPhamLiMit(0);
	List<SanPham> allSanPham=sanPhamService.LayDanhSachSanPhamLiMit(-1);
	List<DanhMucSanPham> listDanhMuc=danhMucService.listDanhMuc();
	
	double tongsopage= Math.ceil(allSanPham.size()/5);
	modelMap.addAttribute("listSanPhams", listSanPham);
	modelMap.addAttribute("tongsopage", tongsopage);
	modelMap.addAttribute("listDanhMuc", listDanhMuc);
	return "themsanpham";	
	}
}
