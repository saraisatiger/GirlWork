package girlwork.service;

import girlwork.domain.EnergyFarm;
import girlwork.repository.EnergyFarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnergyFarmService {
    @Autowired
    EnergyFarmRepository repo;

    public List<EnergyFarm> getAll() {
        return repo.findAll();
    }

}
