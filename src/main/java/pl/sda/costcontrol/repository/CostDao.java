package pl.sda.costcontrol.repository;

import org.springframework.stereotype.Repository;
import pl.sda.costcontrol.dto.CostDto;
import pl.sda.costcontrol.type.CostType;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CostDao {
    public static List<CostDto> costs = new ArrayList<>();
    static {
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
                .type(CostType.CREDIT_CARD)
                .name("Dinner in restaurant")
                .amount(BigDecimal.valueOf(43).setScale(2))
                .build());
        costs.add(CostDto.builder()
                .id(4L)
                .costDate(LocalDate.now())
                .type(CostType.CREDIT_CARD)
                .name("Fuel")
                .amount(BigDecimal.valueOf(100).setScale(2))
                .build());
    }

}
