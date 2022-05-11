import java.util.ArrayList;
import java.util.Collections;

public class Cliente implements Comparable<Cliente> {
    private String nome;
    private ArrayList<Pedido> pedidos;

    Cliente(String nome){
        this.setNome(nome);
        ArrayList<Pedido> pedidosConstruct = new ArrayList<Pedido>(170);
        this.pedidos = pedidosConstruct;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    public Pedido getPedido0(){
        return this.pedidos.get(0);
    }
    public Pedido getPedido(int i){
        return this.pedidos.get(i);
    }
    public void addPedido(int numProdutos, int prazo){
        Pedido novo = new Pedido(this.nome, numProdutos, prazo, Esteira.ID);
        empacotar(novo);
        this.ordenarPorPrazo();
    }
    public void removePedido(){
        this.pedidos.remove(0);
    }
    private void ordenarPorPrazo(){
        for(int i=0;i<pedidos.size();i++){
            if(pedidos.get(i).getPrazo()==0){
                Collections.swap(pedidos, i, pedidos.size()-1);
            }
        }
        Collections.sort(this.pedidos);
    }
    
    public void empacotar(Pedido pedido) {
        while(pedido.getNumProdutos()>=20) {
            pedido.setNumProdutos(pedido.getNumProdutos()-20);
            Pedido p = new Pedido(this.nome, 20, pedido.getPrazo(), Esteira.ID);
            this.pedidos.add(p);				
        }
        Esteira.ID++;
	}
    public static void main(String[] args) {
        Cliente primeiro = new Cliente("Jose");
        primeiro.addPedido(40, 3); 
        primeiro.addPedido(20, 1);
        primeiro.addPedido(20, 2);
        System.out.println(primeiro.getPedidos().toString());
    }
    
    
    @Override
    public int compareTo(Cliente o) {
        if(this.pedidos.get(0).getPrazo()==0)return 1;
        if(this.pedidos.get(0).getPrazo()>o.getPedido0().getPrazo()){
            return 1;
        } else if(this.pedidos.get(0).getPrazo()<o.getPedido0().getPrazo()){
            return -1;
        } else {
            return 0;
        }
    }
}