package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import Servicios.Model;

@Entity
public class Restriccion extends Model{
    @Id
    @GeneratedValue
    private Long id;
    public Double cotaSuperior;
    public Double cotaInferior;

    public Restriccion() {

    }

    public Double getCotaSuperior() {
        return cotaSuperior;
    }

    public void setCotaSuperior(Double cotaSuperior) {
        this.cotaSuperior = cotaSuperior;
    }

    public Double getCotaInferior() {
        return cotaInferior;
    }

    public void setCotaInferior(Double cotaInferior) {
        this.cotaInferior = cotaInferior;
    }

    public void setCotasAireAcondicionado() {
        cotaSuperior = 360d;
        cotaInferior = 90d;
    }

    public void setCotasLampara() {
        cotaSuperior = 360d;
        cotaInferior = 90d;
    }

    public void setCotasTelevisor() {
        cotaSuperior = 360d;
        cotaInferior = 90d;
    }

    public void setCotasLavarropa() {
        cotaSuperior = 6d;
        cotaInferior = 30d;
    }

    public void setCotasComputadora() {
        cotaSuperior = 360d;
        cotaInferior = 60d;
    }

    public void setCotasMicroondas() {
        cotaSuperior = 15d;
        cotaInferior = 3d;
    }

    public void setCotasPlancha() {
        cotaSuperior = 30d;
        cotaInferior = 3d;
    }

    public void setCotasVentilador() {
        cotaSuperior = 360d;
        cotaInferior = 120d;
    }

}
