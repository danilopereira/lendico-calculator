package com.danilopereira.web;

import com.danilopereira.dto.RepaymentRequest;
import com.danilopereira.dto.RepaymentResponse;
import com.danilopereira.service.repayment.RepaymentCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RepaymentController {

    @Autowired
    private RepaymentCalculatorService repaymentCalculatorService;

    @PostMapping("/generate-plan")
    public ResponseEntity<List<RepaymentResponse>> generatePlan(@Valid @RequestBody RepaymentRequest repaymentRequest){
        List<RepaymentResponse> repaymentResponses = repaymentCalculatorService.calculateRepayment(repaymentRequest);

        return new ResponseEntity<>(repaymentResponses, HttpStatus.OK);
    }

}
