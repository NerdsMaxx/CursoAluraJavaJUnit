package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusServiceTest {
    
    @Test
    void deveriaLancarExcecaoParaFuncionarioComSalarioMuitoAlto() {
        final BonusService service = new BonusService();
		final Funcionario funcionario = new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("25000.00"));
  
		assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(funcionario));
    }
    
    @Test
    void bonusDeveria10PorCentoDoSalario() {
        final BonusService service = new BonusService();
		final Funcionario funcionario = new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("2500.00"));
        final BigDecimal bonus = service.calcularBonus(funcionario);
        
        assertEquals(new BigDecimal("250.00"), bonus);
    }
    
    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        final BonusService service = new BonusService();
		final Funcionario funcionario = new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("10000.00"));
        final BigDecimal bonus = service.calcularBonus(funcionario);
        
        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}