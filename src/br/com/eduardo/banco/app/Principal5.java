package br.com.eduardo.banco.app;

import java.math.BigDecimal;

import br.com.eduardo.banco.modelo.Banco;
import br.com.eduardo.banco.modelo.Conta;

public class Principal5 {

  public static void main(String[] args) {
    Banco banco = new Banco();

    // banco.buscar(123, 333)
    // .ifPresent(conta -> System.out.println(conta.getSaldo()));

    // Conta contaEncontrada = banco.buscar(123, 333)
    // .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    // System.out.println(contaEncontrada.getSaldo());

    BigDecimal saldo = banco.buscar(123, 333)
        .map(Conta::getSaldo)
        .orElse(BigDecimal.ZERO);
    System.out.println(saldo);

  }
}
