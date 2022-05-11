//Leitor para simulação com ordenação por prazo 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitor implements Runnable {
	static String nome;
	static int numero;
	static int prazo;
	double tempoGastoPelaEsteira = 0.5;
	int numeroDePacotesFechados = 0;
	int entregasForaDoPrazo = 0;
	static Esteira esteira1 = new Esteira();
	static Esteira esteira2 = new Esteira();


	@Override
		public void run() {
	}


	private static Runnable e1 = new Runnable() {

        public void run() {
            try{

				double tempoGastoPelaEsteira = 0.5;
				int numeroDePacotesFechados = 0;
				int entregasForaDoPrazo = 0;
				while (tempoGastoPelaEsteira < 14394.5) {
					int i = 0;
					tempoGastoPelaEsteira += 5.5;
					numeroDePacotesFechados++;
					if (esteira1.pacotes.get(i).getPrazo() > tempoGastoPelaEsteira) {
						entregasForaDoPrazo++;
					}
				}
				for (int i = 0; i < esteira1.pacotes.size(); i++) {
					if (esteira1.pacotes.get(i).getPrazo() != 999) {
					}
				}

				while (tempoGastoPelaEsteira < 14394.5) {
					int i = 0;
					tempoGastoPelaEsteira += 5.5;
					numeroDePacotesFechados++;
					if (esteira1.pacotes.get(i).getPrazo() > tempoGastoPelaEsteira) {
						entregasForaDoPrazo++;
					}
				}
				//System.out.println("A esteira 1 gastou "+tempoGastoPelaEsteira+" segundos");				
				System.out.println("Pacotes fechados até 12:00 na esteira 1: " + numeroDePacotesFechados);
				System.out.println("Pacotes prioritários entregues fora do prazo com a organização por prazo na esteira 1: " + entregasForaDoPrazo);
                
            } catch (Exception e){
				System.out.println("erro thread 1");
			}
       }
    };

	private static Runnable e2 = new Runnable() {
        public void run() {
			try{
				double tempoGastoPelaEsteira = 0.5;
				int numeroDePacotesFechados = 0;
				int entregasForaDoPrazo = 0;
				while (tempoGastoPelaEsteira < 14394.5) {
					int i = 0;
					tempoGastoPelaEsteira += 5.5;
					numeroDePacotesFechados++;
					if (esteira2.pacotes.get(i).getPrazo() > tempoGastoPelaEsteira) {
						entregasForaDoPrazo++;
					}
				}
				for (int i = 0; i < esteira2.pacotes.size(); i++) {
					if (esteira2.pacotes.get(i).getPrazo() != 999) {
					}
				}

				while (tempoGastoPelaEsteira < 14394.5) {
					int i = 0;
					tempoGastoPelaEsteira += 5.5;
					numeroDePacotesFechados++;
					if (esteira2.pacotes.get(i).getPrazo() > tempoGastoPelaEsteira) {
						entregasForaDoPrazo++;
					}
				}
				//System.out.println("A esteira 2 gastou "+tempoGastoPelaEsteira+" segundos");				
				System.out.println("Pacotes fechados até 12:00 na esteira 2: " + numeroDePacotesFechados);
				System.out.println("Pacotes prioritários entregues fora do prazo com a organização por prazo na esteira 2: " + entregasForaDoPrazo);
			}catch(Exception e){
				System.out.println(esteira2.pacotes.size());
			}		
			
       }
    };

	public static void main(String[] args) throws IOException  {
		FileInputStream stream = new FileInputStream("src/dados_tp01.txt");//inserir caminho dos dados 
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);

		String linha = br.readLine();
		int contador = 0;
		while (linha != null) {
			nome = linha.substring(0, linha.indexOf(';'));
			String num = linha.substring(linha.indexOf(';') + 1, linha.lastIndexOf(';'));
			numero = Integer.parseInt(num);
			String pra = linha.substring(linha.lastIndexOf(';') + 1, linha.length());
			prazo = Integer.parseInt(pra);
			if(contador%2==0){
				contador++;
				esteira1.addPedido(nome, numero, prazo);
			} else {
				contador++;
				esteira2.addPedido(nome, numero, prazo);
			}
			linha = br.readLine();
		}
		br.close();

		esteira1.ordenarEsteira();
		esteira2.ordenarEsteira();

	    new Thread(e1).start();
		new Thread(e2).start();
		
	}
}