package ExercMenin1;

// Interface Buffer especifica métodos chamados por Producer e Consumer
// Interface Buffer utilizada nos exemplos de produtor/consumidor
public interface Buffer {

    public void set(int value); // coloca um valor int no buffer

    public int get();           // retorna o valor int a partir do buffer

}
