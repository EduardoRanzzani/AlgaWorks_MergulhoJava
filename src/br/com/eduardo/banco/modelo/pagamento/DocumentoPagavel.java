package br.com.eduardo.banco.modelo.pagamento;

public interface DocumentoPagavel {

    double getValorTotal();

    boolean estaPago();

    void quitarPagamento();

    default void imprimirRecibo() {
        System.out.println("*** RECIBO: ");
        System.out.println("*** Valor Total: " + getValorTotal());
        System.out.println("*** Pago: " + (estaPago() ? "Sim" : "Não"));
        System.out.println("*** ");
    }

}
