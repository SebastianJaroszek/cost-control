package pl.sda.costcontrol.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Search {

    private BigDecimal from;
    private BigDecimal to;
    private String name;

}
