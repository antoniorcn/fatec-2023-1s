class No { 
    int[] payload = new int[100000];
    No proximo;
}
public class EstouraHeap { 
    public static void main(String[] args) { 
        long numInstancia = 1;
        No raiz = new No();
        No temp = new No();
        raiz.proximo = temp;
        System.out.println("Inicio do programa");
        while(true) {
            temp.proximo = new No();
            temp = temp.proximo;
            System.out.println("Instancia: " + numInstancia++);
        }
    }
}