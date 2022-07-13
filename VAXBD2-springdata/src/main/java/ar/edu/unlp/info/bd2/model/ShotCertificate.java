package ar.edu.unlp.info.bd2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ShotCertificate implements Serializable {

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public ShotCertificate(Date fechaEmicion) {
        Random rand = new Random();
        this.serialNumber = rand.nextInt();
        this.fechaEmicion = fechaEmicion;
    }

	public ShotCertificate() {
	}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
    
	int serialNumber;
    
    @Temporal(TemporalType.TIMESTAMP)
	Date fechaEmicion;

	public int getSerialNumber() {
		return serialNumber;
	}

	public Date getFechaEmicion() {
		return fechaEmicion;
	}

	public void setFechaEmicion(Date fechaEmicion) {
		this.fechaEmicion = fechaEmicion;
	}
}
