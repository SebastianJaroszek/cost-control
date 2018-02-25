package pl.sda.costcontrol.bo;

import org.springframework.stereotype.Service;
import pl.sda.costcontrol.dto.CostDto;
import pl.sda.costcontrol.type.CostType;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author trutyna
 */
@Service
public class CostFinder {

    private List<CostDto> costs = new ArrayList<>();

    @PostConstruct
    public void initList() {
        costs.add(CostDto.builder()
                .id(1L)
                .costDate(LocalDate.now())
                .type(CostType.CASH)
                .name("4 beers")
                .amount(BigDecimal.TEN.setScale(2))
                .build());
        costs.add(CostDto.builder()
                .id(2L)
                .costDate(LocalDate.now())
                .type(CostType.CASH)
                .name("New smartphone")
                .amount(BigDecimal.valueOf(520).setScale(2))

                .build());
        costs.add(CostDto.builder()
                .id(3L)
                .costDate(LocalDate.now())
                .type(CostType.CASH)
                .name("Dinner in restaurant")
                .amount(BigDecimal.valueOf(43).setScale(2))
                .build());
        costs.add(CostDto.builder()
                .id(4L)
                .costDate(LocalDate.now())
                .type(CostType.CASH)
                .name("Fuel")
                .amount(BigDecimal.valueOf(100).setScale(2))
                .build());
    }

    public List<CostDto> findCosts() {
        return this.costs;
    }

    public CostDto findCostDetails(Long id) {
        return this.costs.stream().filter(c -> c.getId().equals(id))
                .findFirst().orElseThrow(() -> new NoSuchElementException());
    }
}
