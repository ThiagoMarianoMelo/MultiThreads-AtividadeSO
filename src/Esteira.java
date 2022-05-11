//Esteira para simulação com ordenação por prazo 
import java.util.ArrayList;
import java.util.Collections;

public class Esteira{
	ArrayList<Cliente> clientes;
    public ArrayList<Pedido> pacotes;
    public static double TEMPO = 0.5;
	public static int ID = 1;
    public static int PEDIDOS_ENTREGUES = 0;

    public Esteira() {
    	ArrayList<Cliente> clientesConstruct = new ArrayList<>(10000000);
		this.clientes = clientesConstruct;
		ArrayList<Pedido> esteiraConstruct = new ArrayList<>(10000000);
		this.pacotes = esteiraConstruct;
	}
    
    public void addCliente(String nome) {
    	if(clientes.size()!=0) {
    	for(int i=0;i<clientes.size();i++){
    	 if(clientes.get(i).getNome()==nome) {
    		 break;
    	 }
    	 else {
    		 Cliente c = new Cliente(nome);
    		 clientes.add(c);
    	 }
    	}
    	}
    	else {
   		 Cliente c = new Cliente(nome);
   		 clientes.add(c);
   	 }
    }
	public void addPedido(String nomeCliente, int numProdutos, int prazo){
        boolean clienteFidelizado = false;
        for(int i=0; i<clientes.size();i++){
            if(nomeCliente.equalsIgnoreCase(clientes.get(i).getNome())){
                this.clientes.get(i).addPedido(numProdutos, prazo);
                clienteFidelizado = true;
                break;
            }
        }
        if(!clienteFidelizado){
            Cliente novo = new Cliente(nomeCliente);
            novo.addPedido(numProdutos, prazo);
            this.clientes.add(novo);
        }
    }
    public void ordenarEsteira(){
    	for(int i=0;i<clientes.size();i++){
			this.pacotes.addAll(clientes.get(i).getPedidos());
    	}
    	 for(int i=0;i<pacotes.size();i++){
             if(pacotes.get(i).getPrazo()==0){
                 Collections.swap(pacotes, i, pacotes.size()-1);
             }
         }
        // Collections.sort(pacotes);
    	 Collections.sort(pacotes, new Comparar());
     }

    public double calculaTempo() {
    	double tempo = TEMPO;
    	for(int i=0;i<pacotes.size();i++){
    		tempo=tempo +5.5;
    	}
    	return tempo;
    }
    
    /*
    public static void main(String[] args) {
    	Esteira e = new Esteira();
    	Cliente c1 = new Cliente("");
    	Cliente c2 = new Cliente("");
    	
    	c1.addPedido(510, 1);
    	c1.addPedido(110, 3);
    	//c1.addPedido(5, 5);
    	//c1.addPedido(5, 7);
    	//c1.addPedido(5, 9);
    	c2.addPedido(113, 2);
    	c2.addPedido(29, 4);
   		c2.addPedido(5, 6);
    	c2.addPedido(5, 8);
    	c2.addPedido(5, 10); 
    	
    	e.clientes.add(c1);
    	e.clientes.add(c2);
    	
    	e.ordenarEsteira();
    	System.out.println(e.pacotes);
    	System.out.println(e.calculaTempo());
    	System.out.println(e.pacotes.size());
    }
    */
    
    }
	

