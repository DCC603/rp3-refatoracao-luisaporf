import java.util.ArrayList;
import java.util.List;

public class Conta {

    private Cliente cliente;
    private Agencia agencia;
    private int numConta;

    private double saldo;

    private List<Operacao> operacoes;

    public Conta(Cliente cliente, Agencia agencia, int numConta, double saldo) {
        this.cliente = cliente;
        this.agencia = agencia;
        this.numConta = numConta;
        this.saldo = saldo;

        this.operacoes = new ArrayList<>();
    }

    public Conta() {
        this(null, null, 0, 0);
    }

    public void depositar(double valor) {
        Operacao op = new Operacao('d', valor);
        this.operacoes.add(op);
        this.saldo += valor;
    }

    public void sacar(double valor) {
        Operacao op = new Operacao('s', valor);
        this.operacoes.add(op);
        this.saldo -= valor;
    }

    public void realizarOperacao(char tipo, int valor) {
        if (tipo == 'd')
            depositar(valor);
        else if(tipo == 's')
            sacar(valor);
    }

    public String toString() {
        String dadosCliente = this.cliente.toString();

        String dadosConta = String.format("%s\nConta: %d\nSaldo: %.2f",
                this.agencia.toString(), this.numConta, this.saldo);

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
