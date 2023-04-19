import java.util.concurrent.locks.Condition;
//Politica signal y continua

class monitor Pelu{
    //peluqueros <- empezarCorte() corte terminarCorte()
    //clientes <- cortarseElPelo

    //TRAZA 
    // empezarACortar->cortarseElPelo->TerminarDeCortar 
    public int peluqueros_libres = 0; 
    public int clientes_esperando = 0; 

    public Condition fila_clientes; 
    public Condition fila_peluqueros; 

    void cortarseElPelo(){
        while(peluqueros_libres == 0){
            fila_clientes.wait(); 
        }
        //signal para terminar el corte
        peluqueros_libres.signal();
    }

    void empezarCorte(){
        while(clientes_esperando == 0){
            fila_peluqueros.wait(); 
        }
        //signal para clientes
        
    }
     
    void terminarCorte(){
        //signal al peluquero 
        //signal al cliente
    }
}
