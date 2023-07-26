package br.com.eduardo.banco.app;

import java.util.function.ToIntFunction;

import br.com.eduardo.banco.modelo.Conta;

public class NumeroContaFunction implements ToIntFunction<Conta> {

  @Override
  public int applyAsInt(Conta value) {
    return value.getNumero();
  }

}
