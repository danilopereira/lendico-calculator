package com.danilopereira.service.repayment;

import com.danilopereira.dto.RepaymentRequest;
import com.danilopereira.dto.RepaymentResponse;
import com.danilopereira.service.annuity.AnnuityCalculatorService;
import com.danilopereira.service.interest.InterestCalculatorService;
import com.danilopereira.service.principal.PrincipalCalculatorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class RepaymentCalculatorServiceImplTest {


    private AnnuityCalculatorService annuityCalculatorService = Mockito.mock(AnnuityCalculatorService.class);

    private InterestCalculatorService interestCalculatorService = Mockito.mock(InterestCalculatorService.class);

    private PrincipalCalculatorService principalCalculatorService = Mockito.mock(PrincipalCalculatorService.class);

    private RepaymentCalculatorService repaymentCalculatorService =
            new RepaymentCalculatorServiceImpl(annuityCalculatorService, interestCalculatorService, principalCalculatorService);

    private RepaymentRequest repaymentRequest = new RepaymentRequest();
    @Before
    public void setUp(){
        repaymentRequest.setDuration(24);
        repaymentRequest.setLoanAmount(new BigDecimal(5000));
        repaymentRequest.setNominalRate(new BigDecimal(5));
        repaymentRequest.setStartDate(LocalDateTime.now());

        when(annuityCalculatorService.calculateAnnuity(any())).thenReturn(new BigDecimal(219.36));
        when(interestCalculatorService.calculateInterest(any(), any())).thenReturn(new BigDecimal(20.83));
        when(principalCalculatorService.calculatePrincipal(any(), any())).thenReturn(new BigDecimal(100));
    }

    @Test
    public void testCalculateRepayment(){
        List<RepaymentResponse> repaymentResponses = repaymentCalculatorService.calculateRepayment(repaymentRequest);
        assertNotNull(repaymentResponses);
        assertEquals(repaymentResponses.size(), repaymentRequest.getDuration());
    }
}
