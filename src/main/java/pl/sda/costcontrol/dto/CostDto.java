package pl.sda.costcontrol.dto;

import lombok.*;
import pl.sda.costcontrol.type.CostType;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author trutyna
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CostDto {
    private Long id;
    private String name;
    private LocalDate costDate;
    private BigDecimal amount;
    private CostType type;
}
