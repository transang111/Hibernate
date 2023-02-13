package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.core.InteractionCallback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import Entity.GioHang;
import Entity.SanPham;
import Service.NhanVienService;
import Service.SanPhamService;

@Controller
@RequestMapping("api/")
@SessionAttributes({"user","giohang"})
public class ApiController {
	@Autowired
	NhanVienService nhanvienservice;
	
	@Autowired
	SanPhamService sanPhamService;
	
 
	@GetMapping("KiemTraDangNhap")
	@ResponseBody
	public String KiemTraDangNhap(@RequestParam String email,@RequestParam String matkhau,ModelMap modelmap) {
		boolean kiemtra=nhanvienservice.KiemTraDangNhap(email, matkhau);
		modelmap.addAttribute("user", email);
		return ""+kiemtra;
	}
	@GetMapping("CapNhatGioHang")
	@ResponseBody
	public void CapNHatGioHang(HttpSession httpSession,@RequestParam int soluong,@RequestParam int masp,@RequestParam int mamau,@RequestParam int masize) {
		if(httpSession.getAttribute("giohang")!=null) {
			List<GioHang> listGioHangs=(List<GioHang>) httpSession.getAttribute("giohang");
			int vitri= KiemtraSanPhamDaTonTaiGioHang(masp, masize, mamau, httpSession);
			listGioHangs.get(vitri).setSoluong(soluong);
		}
	}
	@GetMapping("XoaGioHang")
	@ResponseBody
	public void XoaGioHang(@RequestParam int masp,@RequestParam int masize,@RequestParam int mamau,HttpSession httpSession) {
		if(httpSession.getAttribute("giohang")!=null) {
			List<GioHang> listGioHangs=(List<GioHang>) httpSession.getAttribute("giohang");
			int vitri= KiemtraSanPhamDaTonTaiGioHang(masp,masize, mamau, httpSession);
			listGioHangs.remove(vitri);
		}
	}
	
	@GetMapping("ThemGioHang")
	@ResponseBody
	public String ThemGioHang(@ModelAttribute GioHang giohang,HttpSession httpSession) {
		if(httpSession.getAttribute("giohang")==null) {
			List<GioHang> listgioHang= new ArrayList<GioHang>();
			listgioHang.add(giohang);
			httpSession.setAttribute("giohang", listgioHang);
			return listgioHang.size()+"";
		}else {
			  int vitri=KiemtraSanPhamDaTonTaiGioHang(giohang.getMasp(),giohang.getMasize(), giohang.getMamau(), httpSession);
			  if(vitri==-1) {
			      List<GioHang> listgioHang= (List<GioHang>) httpSession.getAttribute("giohang");
				  listgioHang.add(giohang);
			  }else {
				  List<GioHang> listgioHang= (List<GioHang>) httpSession.getAttribute("giohang");
				  int soluongmoi=listgioHang.get(vitri).getSoluong() + 1;
				  listgioHang.get(vitri).setSoluong(soluongmoi);
			  }
			  List<GioHang> listgioHang= (List<GioHang>) httpSession.getAttribute("giohang");
			  return listgioHang.size()+"";
		}
			  
	}
	/*
	 * @GetMapping("LaySoLuongSanPham")
	 * 
	 * @ResponseBody public String LaysoLuongSanPham(HttpSession httpSession) {
	 * if(httpSession.getAttribute("giohang")!=null) { List<GioHang>
	 * listGioHang=(List<GioHang>) httpSession.getAttribute("giohang"); return
	 * ""+listGioHang.size(); } return ""; }
	 */
	
	private int KiemtraSanPhamDaTonTaiGioHang(int masp,int masize, int mamau, HttpSession httpSession) {
		List<GioHang> listGioHangs=(List<GioHang>) httpSession.getAttribute("giohang");
		for (int i = 0; i < listGioHangs.size(); i++) {
			if(listGioHangs.get(i).getMasp()==masp&&listGioHangs.get(i).getMasize()==masize&&listGioHangs.get(i).getMamau()==mamau) {
				return i;
			}
		}
		
		return -1;
	}
	@GetMapping(path ="LaySanPhamLimit",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String LaySanPhamLimit(@RequestParam int spbatdau) {
		String html="";
		List<SanPham> lisPhams=sanPhamService.LayDanhSachSanPhamLiMit(spbatdau);
		for (SanPham sanPham : lisPhams) {
			html +="<tr>";
			html +="<td><div class='checkbox'><label ><input class='checkboxsanpham' type='checkbox' value='"+sanPham.getMasanpham()+ "' ></label></div></td>";
			html += "<td class='tensp' data-masp='"+sanPham.getMasanpham()+"'>"+sanPham.getTensanpham()+"</td>";
			html +="<td class='giatien' >"+sanPham.getGiatien()+"</td>";
			html +="<td class='gianhcho'>"+sanPham.getGianhcho()+"</td>";
			html +="</tr>";
		}
		return html;
	}
	@GetMapping("xoaSanPham")
	@ResponseBody
	public String XoaSanPhamTheoMa(@RequestParam int masanpham) {
        sanPhamService.XoaSanPhamTheoMaSanPham(masanpham);
		return "";
	}
	@Autowired
	ServletContext context;
	
	@PostMapping("Uploadfile")
	@ResponseBody
	public String Uploadfile(MultipartHttpServletRequest request) {
		String path_save_file = context.getRealPath("/resources/Image/sanpham/");
		Iterator<String> listNames= request.getFileNames();
		MultipartFile mpf= request.getFile(listNames.next());
		
		File file_save= new File(path_save_file + mpf.getOriginalFilename());
		try {
			mpf.transferTo(file_save);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "true";
	}
	
}
