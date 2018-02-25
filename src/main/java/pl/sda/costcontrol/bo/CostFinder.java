package pl.sda.costcontrol.bo;

import org.springframework.stereotype.Service;
import pl.sda.costcontrol.dto.CostDto;
import pl.sda.costcontrol.type.CostType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author trutyna
 */
@Service
public class CostFinder {

    public List<CostDto> findCosts() {
        List<CostDto> costs = new ArrayList<>();
        costs.add(CostDto.builder()
                .costDate(LocalDate.now())
                .type(CostType.CASH)
                .name("4 beers")
                .amount(BigDecimal.TEN.setScale(2))

                .build());

        return costs;
    }

}
