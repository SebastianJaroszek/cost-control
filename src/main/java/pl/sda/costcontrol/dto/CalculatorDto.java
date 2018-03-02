package pl.sda.costcontrol.dto;


import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorDto {
    private BigDecimal parametr1;
    private String operator;
    private BigDecimal parametr2;
}
