package br.com.eduardo.banco.app;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.eduardo.banco.modelo.Banco;
import br.com.eduardo.banco.modelo.Conta;
import br.com.eduardo.banco.modelo.Pessoa;

public class Principal4 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Banco banco = new Banco();

    Set<Pessoa> titulares = banco.getContas().stream()
        .map(Conta::getTitular)
        .distinct()
        .collect(Collectors.toSet());
    System.out.println("Titulares: " + titulares);

    BigDecimal saldoTotal = banco.getContas().stream()
        .map(Conta::getSaldo)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
    System.out.println("Total das Contas: " + saldoTotal);

    banco.getContas().stream()
        .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0)
        .filter(conta -> conta.getNumero() > 200)
        .map(Conta::getTitular)
        .distinct()
        .forEach(System.out::println);

    // banco.getContas().stream()
    // .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0)
    // .filter(conta -> conta.getNumero() > 200)
    // .sorted(Comparator.comparingInt(Conta::getNumero))
    // .forEach(conta -> {
    // System.out.println(conta.getAgencia() + "/" + conta.getNumero() + " = " +
    // conta.getSaldo());
    // });
  }
}
