public class Operacao {

    private TipoOperacao tipo;
    private double valor;

    public Operacao(TipoOperacao tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public Operacao(char codigoTipo, double valor) {
        this(TipoOperacao.fromCodigo(codigoTipo), valor);
    }

    public TipoOperacao getTipo() {
        return tipo;
    }

    public String toString() {
        return this.tipo.getDescricao() + ":\t" + this.valor;
    }
}
