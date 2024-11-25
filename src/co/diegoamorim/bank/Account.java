package co.diegoamorim.bank;

public class Account {
    // Constante tamanho máximo
    private static final int MAX_LENGTH = 12;

    // Propriedades (Agencia, Conta, Nome, Balanco)
    private String ag;
    private String cc;
    private String name;
    private double balance;

    private Log logger;

    // Construtor
    public Account(String ag, String cc, String name) {
        this.ag = ag;
        this.cc = cc;
        setName(name);
        logger = new Log();
    }

    // Setter - Inserir nome com validacao de 12 caracteres
    public void setName(String name) {
        // Se o tamanho de name for maior que o tamanho máximo
        if (name.length() > MAX_LENGTH) {
            // Cortar nome
            this.name = name.substring(0, MAX_LENGTH);
        } else {
            this.name = name;
        }
    }

    // Funçao deposito
    public void deposit(double value){
        balance += value;
        logger.out("DEPOSITO - Valor depositado: R$" + value + ", total atual: R$" + balance);
    }

    // Funçao de saque
    public boolean withDraw(double value){

        boolean result = true;

        // Validacao, se valor da conta é menor que valor do saque
        if(balance < value){
            // Retornar falso
            logger.out("SAQUE - Valor a retirar: R$" + value + ", total atual: R$" + balance);
            return false;
        }

        // Logica de saque
        balance -= value;
        logger.out("SAQUE - Valor a retirar: R$" + value + ", total atual: R$" + balance);
        return result;
    }

    // Getter - retornar balanco
    public double getBalance(){
        return balance;
    }

    // Sobreescrevendo toString
    @Override
    public String toString(){
        return "A conta " + this.name + " Agencia " + this.ag + " / N°" + this.cc + " possui: R$ " + balance;
    }
}

