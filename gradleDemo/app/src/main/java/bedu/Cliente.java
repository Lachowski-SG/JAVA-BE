package bedu;

public class Cliente {
    private String nip;
    private int saldo;
    
    public Cliente(String nip, int saldo) {
        this.nip = nip;
        this.saldo = saldo;
    }
    public String getNip() {
        return nip;
    }
    public void setNip(String nip) {
        this.nip = nip;
    }
    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
