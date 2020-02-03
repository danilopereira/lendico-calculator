package com.danilopereira.service.interest;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class InterestCalculationServiceImplTest {

    private InterestCalculatorService interestCalculatorService;

    @Before
    public void setUp(){
        interestCalculatorService = new InterestCalculatorServiceImpl();
    }

    @Test
    public void testCalculateInterest(){
        BigDecimal interest = interestCalculatorService.calculateInterest(new BigDecimal(5000), new BigDecimal(5));

        assertNotNull(interest);
        BigDecimal expected = new BigDecimal(20.83);
        expected = expected.setScale(2, BigDecimal.ROUND_HALF_UP);
        assertEquals(interest, expected);
    }



}
