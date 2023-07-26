package br.com.eduardo.banco.app;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.eduardo.banco.modelo.ContaEspecial;
import br.com.eduardo.banco.modelo.ContaInvestimento;
import br.com.eduardo.banco.modelo.Pessoa;
import br.com.eduardo.banco.modelo.TipoPessoa;
import br.com.eduardo.banco.modelo.atm.CaixaEletronico;
import br.com.eduardo.banco.modelo.excecao.SaldoInsuficienteException;
import br.com.eduardo.banco.modelo.pagamento.Boleto;
import br.com.eduardo.banco.modelo.pagamento.Holerite;

public class Principal {

    public static void main(String[] args) {
        Pessoa titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("12312312311");
        titular1.setRendimentoAnual(new BigDecimal("15000"));
        titular1.setTipo(TipoPessoa.JURIDICA);

        titular1.setDataUltimaAtualizacao(LocalDateTime.parse("2023-07-26T13:00"));
        System.out.println(titular1.getDataUltimaAtualizacao());

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Regina de Oliveira Maciel");
        titular2.setDocumento("22233344455");

        CaixaEletronico caixaEletronico = new CaixaEletronico();
        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 123, 987);
        ContaEspecial suaConta = new ContaEspecial(titular2, 222, 333, new BigDecimal("1000"));

        try {
            minhaConta.depositar(new BigDecimal("30000"));
            minhaConta.sacar(new BigDecimal("1000"));
            minhaConta.debitarTarifaMensal();

            suaConta.depositar(new BigDecimal("15000"));
            suaConta.sacar(new BigDecimal("15500"));
            suaConta.debitarTarifaMensal();

            Boleto boletoEscola = new Boleto(titular2, new BigDecimal("35000"));
            Holerite salarioFuncionario = new Holerite(titular2, new BigDecimal("100"), 160);

            caixaEletronico.pagar(boletoEscola, minhaConta);
            caixaEletronico.pagar(salarioFuncionario, minhaConta);

            caixaEletronico.estornarPagamento(boletoEscola, minhaConta);

            boletoEscola.imprimirRecibo();
            salarioFuncionario.imprimirRecibo();
        } catch (SaldoInsuficienteException e) {
            System.err.println("Erro ao executar operação na conta: " + e.getMessage());
        }

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);
    }
}
