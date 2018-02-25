package pl.sda.costcontrol.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.sda.costcontrol.type.CostType;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author trutyna
 */
@Getter
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
