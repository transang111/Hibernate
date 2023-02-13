package Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Entity.ChiTietHoaDon;
import Entity.ChiTietHoaDonId;
import Entity.GioHang;
import Entity.HoaDon;
import Service.ChiTietHoaDonService;
import Service.HoaDonService;

@Controller
@RequestMapping("/giohang")
public class GioHangController {

	@Autowired
	HoaDonService hoaDonService;
	@Autowired
	ChiTietHoaDonService chiTietHoaDonService;

	@GetMapping
	public String Defaul(HttpSession httpSession, ModelMap modelMap) {
		if (httpSession.getAttribute("giohang") != null) {
			List<GioHang> listgioHang = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsanphamgiohang", listgioHang.size());
			modelMap.addAttribute("listGioHang", listgioHang);
		}

		return "giohang";
	}

	@PostMapping
	public String ThemHoaDon(@RequestParam String tenkhachhang, @RequestParam String sodt,
			@RequestParam String diachigiaohang, @RequestParam String hinhthucgiaohang, @RequestParam String ghichu,
			HttpSession httpSession) {
		if (httpSession.getAttribute("giohang") != null) {
			List<GioHang> listgioHang = (List<GioHang>) httpSession.getAttribute("giohang");
			
			HoaDon hoaDon = new HoaDon();
			hoaDon.setTenkhachhang(tenkhachhang);
			hoaDon.setSodt(sodt);
			hoaDon.setDiachigiaohang(diachigiaohang);
			hoaDon.setGhichu(ghichu);
			
			int idhoadon = hoaDonService.ThemHoaDOn(hoaDon);
			if (idhoadon > 0) {
				Set<ChiTietHoaDon> listChitietHoaDon = new HashSet<ChiTietHoaDon>();
				for (GioHang gioHang : listgioHang) {
					ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();
					chiTietHoaDonId.setMachitietsanpham(gioHang.getMachitiet());
					chiTietHoaDonId.setMahoadon(hoaDon.getMahoadon());
					
					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
					chiTietHoaDon.setChiTietHoaDonId(chiTietHoaDonId);
					chiTietHoaDon.setGiatien(gioHang.getGiatien());
					chiTietHoaDon.setSoluong(gioHang.getSoluong());
					
					chiTietHoaDonService.ThemChiTietHoaDon(chiTietHoaDon);
				}
			} else {
				System.out.println("them that bai");
			}
		}

		return "giohang";
	}

}
