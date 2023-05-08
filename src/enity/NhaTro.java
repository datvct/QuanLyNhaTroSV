package enity;

import java.util.Objects;

public class NhaTro {
	private String maTro;
	private String diaChi;
	private String chuTro;
	private String soDT;
	public NhaTro(String maTro, String diaChi, String chuTro, String soDT) {
		super();
		this.maTro = maTro;
		this.diaChi = diaChi;
		this.chuTro = chuTro;
		this.soDT = soDT;
	}
	

	public NhaTro() {
		
	}
	
	public NhaTro( String maTro ,String diaChi) {
		this(maTro, diaChi, "", "");
	}
	public NhaTro(String maTro) {
		this.maTro = maTro;
	}
	
	
	public String getMaTro() {
		return maTro;
	}

	public void setMaTro(String maTro) {
		this.maTro = maTro;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getChuTro() {
		return chuTro;
	}

	public void setChuTro(String chuTro) {
		this.chuTro = chuTro;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaTro other = (NhaTro) obj;
		return Objects.equals(maTro, other.maTro);
	}

	@Override
	public String toString() {
		return "NhaTro [maTro=" + maTro + ", diaChi=" + diaChi + ", chuTro=" + chuTro + ", soDT=" + soDT + "]";
	}
	
	
	
}
