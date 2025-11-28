import java.util.ArrayList;
import java.util.List;

public class Conta {

    private Cliente cliente;
    private Agencia agencia;
    private int numConta;

    // TODO(#2) REFATORAR: Esse nome não é o ideal para representar o saldo da conta
    private double valor;

    private List<Operacao> operacoes;

    public Conta(Cliente cliente, Agencia agencia, int numConta, double valor) {
        this.cliente = cliente;
        this.agencia = agencia;
        this.numConta = numConta;
        this.valor = valor;

        this.operacoes = new ArrayList<>();
    }

    public Conta() {
        this(null, null, 0, 0);
    }

    // TODO(#3) REFATORAR: Muita responsabilidade para o mesmo método
    public void realizarOperacao(char tipo, int valor) {
        Operacao op = new Operacao(tipo, valor);
        this.operacoes.add(op);

        if (tipo == 'd')
            this.valor += valor;
        else if(tipo == 's')
            this.valor -= valor;
    }

    public String toString() {
        String dadosCliente = this.cliente.toString();

        String dadosConta = String.format("%s\nConta: %d\nSaldo: %.2f",
                this.agencia.toString(), this.numConta, this.valor);

        // TODO(#5) REFATORAR: Essa operação não deveria estar sendo realizada neste método
        String dadosExtrato = "";
        for(Operacao op : this.operacoes) {
            dadosExtrato += op.toString() + "\n";
        }

        return "-----CLIENTE-----\n" +
                dadosCliente +
                "\n\n" +
                "-----CONTA-----\n" +
                dadosConta +
                "\n\n" +
                "-----EXTRATO-----\n" +
                dadosExtrato +
                "\n";
    }
}
