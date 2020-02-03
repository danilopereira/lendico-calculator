package com.danilopereira.service.repayment;

import com.danilopereira.dto.RepaymentRequest;
import com.danilopereira.dto.RepaymentResponse;
import com.danilopereira.service.annuity.AnnuityCalculatorService;
import com.danilopereira.service.annuity.dto.AnnuityRequest;
import com.danilopereira.service.interest.InterestCalculatorService;
import com.danilopereira.service.principal.PrincipalCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class RepaymentCalculatorServiceImpl implements RepaymentCalculatorService {


    private AnnuityCalculatorService annuityCalculatorService;

    private InterestCalculatorService interestCalculatorService;

    private PrincipalCalculatorService principalCalculatorService;

    public RepaymentCalculatorServiceImpl(@Autowired AnnuityCalculatorService annuityCalculatorService,
                                          @Autowired InterestCalculatorService interestCalculatorService,
                                          @Autowired PrincipalCalculatorService principalCalculatorService){
        this.annuityCalculatorService = annuityCalculatorService;
        this.interestCalculatorService = interestCalculatorService;
        this.principalCalculatorService = principalCalculatorService;
    }

    @Override
    public List<RepaymentResponse> calculateRepayment(RepaymentRequest repaymentRequest) {

        List<RepaymentResponse> responses = new ArrayList<>();
        BigDecimal initialOutstandingPrincipal = repaymentRequest.getLoanAmount();
        for(int i = 0; i < repaymentRequest.getDuration(); i++){
            RepaymentResponse repaymentResponse = new RepaymentResponse();

            BigDecimal interest = interestCalculatorService.calculateInterest(initialOutstandingPrincipal, repaymentRequest.getNominalRate());
            BigDecimal annuity = annuityCalculatorService.calculateAnnuity(new AnnuityRequest(repaymentRequest));;
            BigDecimal principal = calculatePrincipal(annuity, interest, initialOutstandingPrincipal);
            BigDecimal remaining = initialOutstandingPrincipal.subtract(principal);

            repaymentResponse.setBorrowerPaymentAmount(calculateBorrowerPaymentAmount(principal, interest));
            repaymentResponse.setInitialOutstandingPrincipal(initialOutstandingPrincipal);
            repaymentResponse.setInterest(interest);
            repaymentResponse.setPrincipal(principal);
            repaymentResponse.setRemainingOutstandingPrincipal(remaining);
            repaymentResponse.setDate(repaymentRequest.getStartDate().plusMonths(i));

            initialOutstandingPrincipal = remaining;

            responses.add(repaymentResponse);
        }

        return responses;
    }

    private BigDecimal calculateBorrowerPaymentAmount(BigDecimal principal, BigDecimal interest) {
        return principal.add(interest);
    }

    private BigDecimal calculatePrincipal(BigDecimal annuity, BigDecimal interest, BigDecimal initialOutstandingPrincipal) {
        if(initialOutstandingPrincipal.compareTo(annuity) == -1){
            return initialOutstandingPrincipal;
        }
        return principalCalculatorService.calculatePrincipal(annuity, interest);
    }
}
