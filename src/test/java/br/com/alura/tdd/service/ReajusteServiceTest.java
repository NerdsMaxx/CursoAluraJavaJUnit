package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.enums.Desempenho;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {
    
    private ReajusteService service;
    private Funcionario funcionario;
    
    @BeforeEach
    public void inicializar() {
        if(Objects.isNull(service)) {
            this.service = new ReajusteService();
        }
        
        this.funcionario = new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("1000.00"));
    }
    
    @Test
    public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADejesar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }
    
    @Test
    public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }
    
    @Test
    public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
    
//    @Test
//    public void reajusteDeveriaSerZeroQuandoDesempenhoForNenhumDosTresOficiais() {
//        ReajusteService service = new ReajusteService();
//        Funcionario funcionario = new Funcionario("Carmen Alexandre", LocalDate.now(), BD.of("12000.00"));
//
//        service.concederReajuste(funcionario, Desempenho.NENHUM);
//
//        assertEquals(BD.of("12000.00"), funcionario.getSalario());
//    }
}