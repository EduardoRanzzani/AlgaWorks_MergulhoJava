package br.com.eduardo.banco.app;

import java.util.Comparator;

import br.com.eduardo.banco.modelo.Banco;
import br.com.eduardo.banco.modelo.Conta;

public class Principal3 {

  public static void main(String[] args) {
    Banco banco = new Banco();

    // ToIntFunction<Conta> function = (Conta conta) -> {
    // return conta.getNumero();
    // };

    // ToIntFunction<Conta> function = Conta::getNumero;

    // banco.getContas().sort(Comparator.comparingInt(new NumeroContaFunction()));
    
    banco.getContas().sort(Comparator.comparingInt(Conta::getNumero));

    for (Conta conta : banco.getContas()) {
      System.out.println(conta.getAgencia() + "/" + conta.getNumero());
    }
  }
}
