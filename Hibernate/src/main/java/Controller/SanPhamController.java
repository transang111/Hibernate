package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Entity.DanhMucSanPham;
import Entity.SanPham;
import Service.DanhMucService;
import Service.SanPhamService;

@Controller
@RequestMapping("sanpham/")
public class SanPhamController {
    
	@Autowired
	DanhMucService danhMucSanPhamService;
	@Autowired
	SanPhamService sanPhamService;
	@GetMapping("{id}/{tendanhmuc}")
	public String defaul(ModelMap modelmap,@PathVariable int id, @PathVariable String tendanhmuc) {
		List<SanPham> listSanPham=sanPhamService.LayDanhSachSanPhamTheoMaDanhMuc(id);
		List<DanhMucSanPham> listDanhMuc=danhMucSanPhamService.listDanhMuc();
		modelmap.addAttribute("listDanhMuc", listDanhMuc);
		modelmap.addAttribute("tendanhmuc", tendanhmuc);
		modelmap.addAttribute("listSanPham", listSanPham);
		return "sanpham";
	}
}
