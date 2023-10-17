package partesProyecto1;

import java.util.Date;

public class TarjetaCredito {
    
    protected int NumeroTarjeta;
    protected Date Vencimiento;
    protected int CVV;

    // Constructor
    public TarjetaCredito(int numeroTarjeta, Date vencimiento, int CVV) {
        this.NumeroTarjeta = numeroTarjeta;
        this.Vencimiento = vencimiento;
        this.CVV = CVV;
    }

    // Getters y setters
    public int getNumeroTarjeta() {
        return NumeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.NumeroTarjeta = numeroTarjeta;
    }

    public Date getVencimiento() {
        return Vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.Vencimiento = vencimiento;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }
}

