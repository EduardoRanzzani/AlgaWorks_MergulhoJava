package br.com.eduardo.banco.app;

import br.com.eduardo.banco.modelo.ContaEspecial;
import br.com.eduardo.banco.modelo.ContaInvestimento;
import br.com.eduardo.banco.modelo.Pessoa;
import br.com.eduardo.banco.modelo.atm.CaixaEletronico;
import br.com.eduardo.banco.modelo.pagamento.Boleto;
import br.com.eduardo.banco.modelo.pagamento.Holerite;

public class Principal {

    public static void main(String[] args) {
        Pessoa titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("12312312311");

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Regina de Oliveira Maciel");
        titular2.setDocumento("22233344455");

        CaixaEletronico caixaEletronico = new CaixaEletronico();
        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 123, 987);
        ContaEspecial suaConta = new ContaEspecial(titular2, 222, 333, 1_000);

        minhaConta.depositar(30_000);
        minhaConta.sacar(1_000);
        minhaConta.creditarRendimentos(0.8);
        minhaConta.debitarTarifaMensal();

        suaConta.depositar(15_000);
        suaConta.sacar(15_500);
        suaConta.debitarTarifaMensal();

        Boleto boletoEscola = new Boleto(titular2, 800);
        Holerite salarioFuncionario = new Holerite(titular2, 100, 160);

        caixaEletronico.pagar(boletoEscola, minhaConta);
        caixaEletronico.pagar(salarioFuncionario, minhaConta);
        caixaEletronico.estornarPagamento(boletoEscola, minhaConta);

        boletoEscola.imprimirRecibo();
        salarioFuncionario.imprimirRecibo();

        System.out.println();
        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);
    }
}
