package br.ce.wcaquino.taskbackend.utils;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class DateUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isEqualOrFutureDate() {
    }

    @Test
    public void deveRetornaTrueParaDatasFuturas(){
        LocalDate date = LocalDate.of(2030,01,01);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));

    }

    @Test
    public void deveRetornaFalseParaDatasPassadas(){
        LocalDate date = LocalDate.of(2020,1,01);
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
    }

    @Test
    public void deveRetornaTrueParaDatasAtual(){
        LocalDate date = LocalDate.now();
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));

    }
}