package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BonusService {
    
    public BigDecimal calcularBonus(Funcionario funcionario) {
        final BigDecimal salario = funcionario.getSalario();
        if (salario.compareTo(new BigDecimal("10000")) > 0) {
            throw new IllegalArgumentException(
                    "Não é permitido funcionário com salário maior que R$ 10000 não pode receber bônus!");
        }
        
        return funcionario.getSalario()
                          .multiply(new BigDecimal("0.1"))
                          .setScale(2, RoundingMode.HALF_UP);
    }
    
}