package com.danilopereira.service.principal;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PrincipalCalculatorServiceImpl implements PrincipalCalculatorService {
    @Override
    public BigDecimal calculatePrincipal(BigDecimal annuity, BigDecimal interest) {
        BigDecimal principal = annuity.subtract(interest);
        principal = principal.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return principal;
    }
}
