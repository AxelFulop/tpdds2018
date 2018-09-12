package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Restriccion {
    @Id
    @GeneratedValue
    private int id;
    public double cotaSuperior;
    public double cotaInferior;

    public Restriccion() {

    }

    public double getCotaSuperior() {
        return cotaSuperior;
    }

    public void setCotaSuperior(double cotaSuperior) {
        this.cotaSuperior = cotaSuperior;
    }

    public double getCotaInferior() {
        return cotaInferior;
    }

    public void setCotaInferior(double cotaInferior) {
        this.cotaInferior = cotaInferior;
    }

    public void setCotasAireAcondicionado() {
        cotaSuperior = 360;
        cotaInferior = 90;
    }

    public void setCotasLampara() {
        cotaSuperior = 360;
        cotaInferior = 90;
    }

    public void setCotasTelevisor() {
        cotaSuperior = 360;
        cotaInferior = 90;
    }

    public void setCotasLavarropa() {
        cotaSuperior = 6;
        cotaInferior = 30;
    }

    public void setCotasComputadora() {
        cotaSuperior = 360;
        cotaInferior = 60;
    }

    public void setCotasMicroondas() {
        cotaSuperior = 15;
        cotaInferior = 3;
    }

    public void setCotasPlancha() {
        cotaSuperior = 30;
        cotaInferior = 3;
    }

    public void setCotasVentilador() {
        cotaSuperior = 360;
        cotaInferior = 120;
    }

}
