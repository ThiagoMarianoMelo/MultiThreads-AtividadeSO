import java.util.Comparator;

public class Comparar implements Comparator<Pedido> {
	public int compare(Pedido a, Pedido b)
    {
		if(a.getPrazo()==0) {
			a.setPrazo(999);
		}
		if(b.getPrazo()==0) {
			b.setPrazo(999);
		}
        return a.getPrazo() - b.getPrazo();
    }

}
