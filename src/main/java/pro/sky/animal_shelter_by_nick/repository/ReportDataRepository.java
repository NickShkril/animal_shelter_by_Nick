package pro.sky.animal_shelter_by_nick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.animal_shelter_by_nick.model.ReportData;

import java.util.Set;

/**
 * Репозиторий для работы с отчетами
 */
@Repository
public interface ReportDataRepository extends JpaRepository<ReportData, Long> {
    Set<ReportData> findListByChatId(Long id);

    ReportData findByChatId(Long id);

}
