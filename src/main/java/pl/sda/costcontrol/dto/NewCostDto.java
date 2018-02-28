package pl.sda.costcontrol.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class NewCostDto {
    private Long id;
    private String name;
    private LocalDate date;
    private BigDecimal amount;
    private CostType type;
}
