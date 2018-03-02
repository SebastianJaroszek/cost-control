package pl.sda.costcontrol.bo;

import org.springframework.stereotype.Service;
import pl.sda.costcontrol.dto.CostDto;
import pl.sda.costcontrol.dto.Search;
import pl.sda.costcontrol.type.CostType;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

import static pl.sda.costcontrol.repository.CostDao.costs;

@Service
public class CostFinder {

    public List<CostDto> findCosts() {
        return costs;
    }

    public List<CostDto> findCostsByType(CostType type) {
        return costs.stream()
                .filter(cost -> cost.getType().equals(type))
                .collect(Collectors.toList());
    }

    public CostDto findCostDetails(Long id) {
        return costs.stream().filter(c -> c.getId().equals(id))
                .findFirst().orElseThrow(() -> new NoSuchElementException());
    }

    public CostDto findCostDetailsByName(String name) {
        return costs.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst().orElseThrow(() -> new NoSuchElementException());
    }

    public List<CostDto> findCostByAmount(BigDecimal from, BigDecimal to) {
        return costs.stream()
                .filter(c -> c.getAmount().compareTo(from) > 0 && c.getAmount().compareTo(to) < 0)
                .collect(Collectors.toList());
    }

    public List<CostDto> findCostsByName(String name) {
        return costs.stream()
                .filter(c -> c.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<CostDto> findCostByCriteria(Search search) {
        return costs.stream()
                .filter(c -> Objects.isNull(search.getName()) || c.getName().contains(search.getName()))
                .filter(c -> Objects.isNull(search.getFrom()) || c.getAmount().compareTo(search.getFrom()) > 0)
                .filter(c -> Objects.isNull(search.getTo()) || c.getAmount().compareTo(search.getTo()) < 0)
                .collect(Collectors.toList());
    }

}
