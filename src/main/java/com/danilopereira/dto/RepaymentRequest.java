package com.danilopereira.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class RepaymentRequest {
    @NotNull
    private BigDecimal loanAmount;
    @NotNull
    private BigDecimal nominalRate;
    @NotNull
    private int duration;
    @NotNull
    private LocalDateTime startDate;
}
