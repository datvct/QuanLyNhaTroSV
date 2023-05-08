package enity;

import java.sql.Date;
import java.util.Objects;

public class HopDong {
	private String maHopDong;
	private SinhVien maSV;
	private SinhVien tenSV;
	private SinhVien lop;
	private SinhVien nganh;
	private PhongTro maPhong;
	private PhongTro tenPhong;
	private PhongTro loaiPhong;
	private double giaPhong;
	private Date ngayLapHD;
	private Date ngayHetHD;
	public String getMaHopDong() {
		return maHopDong;
	}
	
	public PhongTro getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(PhongTro loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public void setMaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
	}
	public SinhVien getMaSV() {
		return maSV;
	}
	public void setMaSV(SinhVien maSV) {
		this.maSV = maSV;
	}
	public PhongTro getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(PhongTro maPhong) {
		this.maPhong = maPhong;
	}
	public double getGiaPhong() {
		return giaPhong;
	}
	public void setGiaPhong(double giaPhong) {
		this.giaPhong = giaPhong;
	}
	public Date getNgayLap() {
		return ngayLapHD;
	}
	public void setNgayLap(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public Date getNgayHetHD() {
		return ngayHetHD;
	}
	public void setNgayHetHD(Date ngayHetHD) {
		this.ngayHetHD = ngayHetHD;
	}
	
	
	public SinhVien getTenSV() {
		return tenSV;
	}
	public void setTenSV(SinhVien tenSV) {
		this.tenSV = tenSV;
	}
	public SinhVien getLop() {
		return lop;
	}
	public void setLop(SinhVien lop) {
		this.lop = lop;
	}
	public SinhVien getNganh() {
		return nganh;
	}
	public void setNganh(SinhVien nganh) {
		this.nganh = nganh;
	}
	public PhongTro getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(PhongTro tenPhong) {
		this.tenPhong = tenPhong;
	}
	public Date getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public HopDong(String maHopDong, SinhVien maSV, PhongTro maPhong, Double giaPhong, Date ngayLapHD, Date ngayHetHD) {
		super();
		this.maHopDong = maHopDong;
		this.maSV = maSV;
		this.maPhong = maPhong;
		this.giaPhong = giaPhong;
		this.ngayLapHD = ngayLapHD;
		this.ngayHetHD = ngayHetHD;
	}
	public HopDong(String maHopDong) {
		super();
		this.maHopDong = maHopDong;
	}
	public HopDong() {
		super();
	}
	public HopDong(String maHopDong, SinhVien maSV, SinhVien tenSV, SinhVien lop, SinhVien nganh, PhongTro maPhong,
			PhongTro tenPhong,PhongTro loaiPhong, double giaPhong, Date ngayLapHD, Date ngayHetHD) {
		super();
		this.maHopDong = maHopDong;
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.lop = lop;
		this.nganh = nganh;
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.loaiPhong = loaiPhong;
		this.giaPhong = giaPhong;
		this.ngayLapHD = ngayLapHD;
		this.ngayHetHD = ngayHetHD;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHopDong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HopDong other = (HopDong) obj;
		return Objects.equals(maHopDong, other.maHopDong);
	}

	public HopDong(double giaPhong) {
		super();
		this.giaPhong = giaPhong;
	}
	
	
	
	
}
