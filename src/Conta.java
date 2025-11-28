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
        Operacao op = new Operacao(TipoOperacao.DEPOSITO, valor);
        this.operacoes.add(op);
        this.saldo += valor;
    }

    public void sacar(double valor) {
        Operacao op = new Operacao(TipoOperacao.SAQUE, valor);
        this.operacoes.add(op);
        this.saldo -= valor;
    }

    public void realizarOperacao(char tipo, int valor) {
        if (tipo == 'd')
            depositar(valor);
        else if(tipo == 's')
            sacar(valor);
    }

    private String gerarExtrato() {
        String extrato = "";
        for(Operacao op : this.operacoes) {
            extrato += op.toString() + "\n";
        }
        return extrato;
    }

    public String toString() {
        String dadosCliente = this.cliente.toString();

        String dadosConta = String.format("%s\nConta: %d\nSaldo: %.2f",
                this.agencia.toString(), this.numConta, this.saldo);

        String dadosExtrato = gerarExtrato();

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
