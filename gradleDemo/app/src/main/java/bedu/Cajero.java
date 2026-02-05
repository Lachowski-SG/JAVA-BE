package bedu;

public class Cajero {
//Cliente de la base de datos
    private Cliente cliente;

    public Cajero(Cliente cliente){
        this.cliente=cliente;
    }
//Preguntar NIP
public boolean validarNip(String nip){
    if (nip.equals(cliente.getNip())){
        return true;        
    } else{
        return false;
    }
// return nip.equals(cliente.getNip());
}
//Abonar
public void abonar(int  monto){
    cliente.setSaldo(cliente.getSaldo()+ monto);
}
//Retirar
}
