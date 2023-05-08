package enity;

import java.io.Serializable;

public class DangNhap implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maTK;
	private String matKhau;
	
	public String getMaTK() {
		return maTK;
	}
	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	public DangNhap() {
		super();
	}
	
	public DangNhap(String maTK, String matKhau) {
		super();
		this.maTK = maTK;
		this.matKhau = matKhau;
	}
	
	public DangNhap(String maTK) {
		super();
		this.maTK = maTK;
	}
	
	@Override
	public String toString() {
		return "TaiKhoan [maTK=" + maTK + ", matKhau=" + matKhau + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTK == null) ? 0 : maTK.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DangNhap other = (DangNhap) obj;
		if (maTK == null) {
			if (other.maTK != null)
				return false;
		} else if (!maTK.equals(other.maTK))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
