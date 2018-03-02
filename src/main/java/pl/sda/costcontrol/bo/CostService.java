package pl.sda.costcontrol.bo;

import org.springframework.stereotype.Service;
import pl.sda.costcontrol.dto.CostDto;
import pl.sda.costcontrol.dto.NewCostDto;
import pl.sda.costcontrol.type.CostType;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static pl.sda.costcontrol.repository.CostDao.costs;

/**
 * @author trutyna
 */
@Service
public class CostService {

    public void deleteCost(Long id) {
        costs.removeIf(c -> c.getId().equals(id));
    }

    public void saveCost(NewCostDto newCostDto){
        CostDto costDto = CostDto.builder()
                .id(Long.valueOf(costs.size()))
                .name(newCostDto.getName())
                .costDate(newCostDto.getDate())
                .amount(newCostDto.getAmount())
                .type(newCostDto.getType())
                .build();
        costs.add(costDto);
    }
}
