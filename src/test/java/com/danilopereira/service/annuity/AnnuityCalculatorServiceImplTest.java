package com.danilopereira.service.annuity;

import com.danilopereira.service.annuity.dto.AnnuityRequest;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AnnuityCalculatorServiceImplTest {

    private AnnuityCalculatorService annuityCalculatorService;

    private AnnuityRequest annuityRequest;

    @Before
    public void setUp(){
        annuityCalculatorService = new AnnuityCalculatorServiceImpl();

        annuityRequest = new AnnuityRequest();
        annuityRequest.setNominalRate(new BigDecimal(5));
        annuityRequest.setAmount(new BigDecimal(5000));
        annuityRequest.setDuration(24);
    }

    @Test
    public void testCalculateAnnuity(){
        final BigDecimal annuity = annuityCalculatorService.calculateAnnuity(annuityRequest);

        BigDecimal expectedAnnuity = new BigDecimal(219.36);
        expectedAnnuity = expectedAnnuity.setScale(2, BigDecimal.ROUND_HALF_UP);

        assertNotNull(annuity);
        assertEquals(annuity, expectedAnnuity);
    }
}
