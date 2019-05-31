package girlwork.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import girlwork.domain.TeamData;

@Repository
public interface TeamDataRepository extends MongoRepository<TeamData, Integer> {

}