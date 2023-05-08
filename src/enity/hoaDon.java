package enity;

import java.sql.Date;

import enity.DichVu;

public class hoaDon {
	private String maHoaDon;
	private HopDong maHD;
	private SinhVien maSV;
	private SinhVien tenSV;
	private PhongTro maPT;
	private Date ngayLap;
	private PhongTro tienPhong;
	private DichVu tenDV;
	private DichVu maDV;
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public HopDong getMaHD() {
		return maHD;
	}
	public void setMaHD(HopDong maHD) {
		this.maHD = maHD;
	}
	public SinhVien getMaSV() {
		return maSV;
	}
	public void setMaSV(SinhVien maSV) {
		this.maSV = maSV;
	}
	public SinhVien getTenSV() {
		return tenSV;
	}
	public void setTenSV(SinhVien tenSV) {
		this.tenSV = tenSV;
	}
	public PhongTro getMaPT() {
		return maPT;
	}
	public void setMaPT(PhongTro maPT) {
		this.maPT = maPT;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public PhongTro getTienPhong() {
		return tienPhong;
	}
	public void setTienPhong(PhongTro tienPhong) {
		this.tienPhong = tienPhong;
	}
	public DichVu getTenDV() {
		return tenDV;
	}
	public void setTenDV(DichVu tenDV) {
		this.tenDV = tenDV;
	}
	public DichVu getMaDV() {
		return maDV;
	}
	public void setMaDV(DichVu maDV) {
		this.maDV = maDV;
	}
	public hoaDon(String maHoaDon, HopDong maHD, SinhVien maSV, SinhVien tenSV, PhongTro maPT, Date ngayLap,
			PhongTro tienPhong, DichVu tenDV, DichVu maDV) {
		super();
		this.maHoaDon = maHoaDon;
		this.maHD = maHD;
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.maPT = maPT;
		this.ngayLap = ngayLap;
		this.tienPhong = tienPhong;
		this.tenDV = tenDV;
		this.maDV = maDV;
	}
	public hoaDon() {
		super();
	}
	@Override
	public String toString() {
		return "hoaDon [maHoaDon=" + maHoaDon + ", maHD=" + maHD + ", maSV=" + maSV + ", tenSV=" + tenSV + ", maPT="
				+ maPT + ", ngayLap=" + ngayLap + ", tienPhong=" + tienPhong + ", tenDV=" + tenDV + ", maDV=" + maDV
				+ "]";
	}
	
	
	
}
