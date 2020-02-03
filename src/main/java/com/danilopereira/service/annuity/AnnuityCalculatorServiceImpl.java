package com.danilopereira.service.annuity;

import com.danilopereira.service.annuity.dto.AnnuityRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AnnuityCalculatorServiceImpl implements AnnuityCalculatorService {

    private final BigDecimal MONTHS_PER_YEAR = new BigDecimal(12);

    @Override
    public BigDecimal calculateAnnuity(AnnuityRequest annuityRequest) {
        BigDecimal realNominalRatePercentage = annuityRequest.getNominalRate().divide(new BigDecimal(100));
        BigDecimal nominalRatePerMonth = realNominalRatePercentage.divide(MONTHS_PER_YEAR, 6, BigDecimal.ROUND_HALF_EVEN);
        double nominalRate = nominalRatePerMonth.doubleValue();
        double annuityCalc = (annuityRequest.getAmount().doubleValue() * nominalRate /
                (1 - Math.pow(1+nominalRate, -annuityRequest.getDuration())));


        BigDecimal annuity = new BigDecimal(annuityCalc);
        annuity = annuity.setScale(2, BigDecimal.ROUND_HALF_UP);

        return annuity;
    }
}
