package ar.edu.unlp.info.bd2.model;

import java.util.Date;

public class ShotCertificate {

	public ShotCertificate() {
	}

	int serialNumber;
	Date fechaEmicion;

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getFechaEmicion() {
		return fechaEmicion;
	}

	public void setFechaEmicion(Date fechaEmicion) {
		this.fechaEmicion = fechaEmicion;
	}

	public ShotCertificate(int sn, Date fecha) {
		this.setSerialNumber(sn);
		this.setFechaEmicion(fecha);
	}
}
