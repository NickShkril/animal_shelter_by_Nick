package pro.sky.animal_shelter_by_nick.service;

import com.pengrad.telegrambot.model.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.animal_shelter_by_nick.exception.ReportDataNotFoundException;
import pro.sky.animal_shelter_by_nick.model.ReportData;
import pro.sky.animal_shelter_by_nick.repository.ReportDataRepository;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Сервис содержащий методы для работы с отчетами
 */

@Service
@Transactional
public class ReportDataService {
    private final ReportDataRepository reportRepository;

    private final Logger logger = LoggerFactory.getLogger(ReportDataService.class);

    public ReportDataService(ReportDataRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    // Метод для загрузки текстового отчета
    public void uploadReportData(Long personId, byte[] pictureFile, File file, String ration, String health,
                                 String habits, String filePath, Date dateSendMessage, Long timeDate, long daysOfReports) throws IOException {
        logger.info("Was invoked method to uploadReportData");
        ReportData report = new ReportData();//findById(personId);
        report.setLastMessage(dateSendMessage);
        report.setDays(daysOfReports);
        report.setFilePath(filePath);
        report.setFileSize(file.fileSize());
        report.setLastMessageMs(timeDate);
        report.setChatId(personId);
        report.setData(pictureFile);
        report.setRation(ration);
        report.setHealth(health);
        report.setHabits(habits);
        reportRepository.save(report);
    }

    // Метод для загрузки отчета с изобраением
    public void uploadReportData(Long personId, byte[] pictureFile, File file,
                                 String caption, String filePath, Date dateSendMessage, Long timeDate, long daysOfReports) throws IOException {
        logger.info("Was invoked method to uploadReportData");
        ReportData report = new ReportData();//findById(personId);
        report.setLastMessage(dateSendMessage);
        report.setDays(daysOfReports);
        report.setFilePath(filePath);
        report.setChatId(personId);
        report.setFileSize(file.fileSize());
        report.setData(pictureFile);
        report.setCaption(caption);
        report.setLastMessageMs(timeDate);
        reportRepository.save(report);
    }

    // Метод, чтобы найти отчет по id
    public ReportData findById(Long id) {
        logger.info("Was invoked method to get a report by id={}", id);
        return reportRepository.findById(id).orElseThrow(ReportDataNotFoundException::new);
    }

    // Метод, чтобы найти отчет по chatId
    public ReportData findByChatId(Long chatId) {
        logger.info("Was invoked method to get a report by chatId={}", chatId);
        return reportRepository.findByChatId(chatId);
    }

    // Метод, что получить список всех отчетов по chatId
    public Collection<ReportData> findListByChatId(Long chatId) {
        logger.info("Was invoked method to findListByChatId a report by id={}", chatId);
        return reportRepository.findListByChatId(chatId);
    }

    // Метод, чтобы сохранить отчет
    public ReportData save(ReportData report) {
        logger.info("Was invoked method to save a report");
        return reportRepository.save(report);
    }

    // Метод, что удалить отчет
    public void remove(Long id) {
        logger.info("Was invoked method to remove a report by id={}", id);
        reportRepository.deleteById(id);
    }

    // Метод, чтобы получить список всех отчетов
    public List<ReportData> getAll() {
        logger.info("Was invoked method to get all reports");
        return reportRepository.findAll();
    }
}
