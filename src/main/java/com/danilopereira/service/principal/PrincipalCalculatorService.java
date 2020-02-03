package com.danilopereira.service.principal;

import java.math.BigDecimal;

public interface PrincipalCalculatorService {

    BigDecimal calculatePrincipal(BigDecimal annuity, BigDecimal interest);
}
