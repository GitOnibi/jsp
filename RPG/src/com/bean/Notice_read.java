package com.bean;

public class Notice_read {
	private Notice nt_data;
	private Notice_content nc_data;
	public Notice_read(Notice nt_data, Notice_content nc_data) {
		super();
		this.nt_data = nt_data;
		this.nc_data = nc_data;
	}
	public Notice getNt_data() {
		return nt_data;
	}
	public void setNt_data(Notice nt_data) {
		this.nt_data = nt_data;
	}
	public Notice_content getNc_data() {
		return nc_data;
	}
	public void setNc_data(Notice_content nc_data) {
		this.nc_data = nc_data;
	}
	
}
