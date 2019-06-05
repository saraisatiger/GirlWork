package girlwork.repository;

import girlwork.domain.EnergyFarm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyFarmRepository extends MongoRepository<EnergyFarm, Integer> {
}
