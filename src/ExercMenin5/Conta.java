package ExercMenin5;

public class Conta {


    public void CreditRemove(Double debitvalue) 
    {
        if (debitvalue > getSaldo()) 
        {
            // Valor é maior que o saldo que há na conta.
            System.out.println("Olá, você não tem esse valor disponível");
            // Mostra Valor Minimo            
            System.out.println("Seu valor disponível para fazer um saque é: " + getSaldo());
        } else 
        {
            setSaldo(getSaldo() - debitvalue);
        }
    }

    public void CreditAdd(Double creditvalue) {
        setSaldo(getSaldo() + creditvalue);
    }
    
    public Conta(Double saldo) {
        this.saldo = saldo;
    }

    private Double saldo;

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
}
