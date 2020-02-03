package com.danilopereira.service.principal;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PrincipalCalculatorServiceImplTest {

    private PrincipalCalculatorService principalCalculatorService;

    @Before
    public void setUp(){
        principalCalculatorService = new PrincipalCalculatorServiceImpl();
    }

    @Test
    public void testCalculatePrincipal(){
        final BigDecimal principal = principalCalculatorService.calculatePrincipal(new BigDecimal(219.36), new BigDecimal(20.83));

        BigDecimal expectedPrincipal = new BigDecimal(198.53);
        expectedPrincipal = expectedPrincipal.setScale(2, BigDecimal.ROUND_HALF_UP);
        assertNotNull(principal);
        assertEquals(principal, expectedPrincipal);
    }
}
