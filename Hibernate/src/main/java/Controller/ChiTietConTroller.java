package Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import Entity.DanhMucSanPham;
import Entity.GioHang;
import Entity.SanPham;
import Service.DanhMucService;
import Service.SanPhamService;

@Controller
@RequestMapping("/chitiet")
@SessionAttributes("giohang")
public class ChiTietConTroller {
	@Autowired
	SanPhamService sanphamService;
	@Autowired
	DanhMucService danhMucSanPhamService;
	
	@GetMapping("/{masanpham}")
    public String  defaul(@PathVariable int masanpham,ModelMap modelMap, HttpSession httpSession) {
		SanPham sanpham= sanphamService.LayDanhSachChiTietSanPhamTheoMa(masanpham);
		List<DanhMucSanPham> listDanhMuc=danhMucSanPhamService.listDanhMuc();
		modelMap.addAttribute("sanpham", sanpham);
		modelMap.addAttribute("listDanhMuc", listDanhMuc);
		if(httpSession.getAttribute("giohang")!=null) {
			List<GioHang> listgioHang=(List<GioHang>)httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsanphamgiohang", listgioHang.size());
		}
    	return "chitiet";
    }
	
}
