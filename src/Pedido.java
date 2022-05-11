
public class Pedido implements Comparable<Pedido> {
    
    private String cliente;
    private int id;
    private int numProdutos;
    private int prazo;
    public static final int VOLUME_PRODUTO = 250;
    
    Pedido(String cliente, int numProdutos, int prazo, int id){
        setCliente(cliente);
        setNumProdutos(numProdutos);
        setPrazo(prazo);
        setId(id);
        
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getCliente() {
        return cliente;
    }
    public void setNumProdutos(int numProdutos) {
        this.numProdutos = numProdutos;
    }
    public int getNumProdutos() {
        return numProdutos;
    }
    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }
    public int getPrazo() {
        return prazo;
    }
    @Override
    public int compareTo(Pedido o) {
        if(this.prazo==0)return 1;
        if(this.prazo>o.getPrazo()){
            return 1;
        } else if(this.prazo<o.getPrazo()){
            return -1;
        } else {
            return 0;
        }
    }
    @Override
    public String toString() {
        return "cliente: "+this.getCliente()+" prazo: "+this.prazo+" id: "+this.getId();
    }
}