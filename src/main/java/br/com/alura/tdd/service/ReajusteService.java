package br.com.alura.tdd.service;

import br.com.alura.tdd.enums.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {
    
    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal salario = funcionario.getSalario();
        BigDecimal reajuste = salario.multiply(desempenho.percentualReajuste());
        funcionario.reajustarSalario(reajuste);
    }
}