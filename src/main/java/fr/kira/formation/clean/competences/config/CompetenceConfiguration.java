package fr.kira.formation.clean.competences.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kira.formation.clean.competences.infra.CompetenceDatasourceMongoAdapter;
import fr.kira.formation.clean.competences.infra.CompetenceRepository;
import fr.kira.formation.clean.competences.usecases.CompetenceDatasource;
import fr.kira.formation.clean.competences.usecases.CompetenceEcritureSerive;
import fr.kira.formation.clean.competences.usecases.CompetenceLectureService;
import fr.kira.formation.clean.competences.usecases.impl.CompetenceEcritureServiceImpl;
import fr.kira.formation.clean.competences.usecases.impl.CompetenceLectureServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompetenceConfiguration {

    @Bean
    public CompetenceLectureService competenceLectureService(CompetenceDatasource datasource) {
        return new CompetenceLectureServiceImpl(datasource);
    }

    @Bean
    public CompetenceDatasource competenceDatasource(CompetenceRepository repository, ObjectMapper mapper) {
        return new CompetenceDatasourceMongoAdapter(repository, mapper);
    }

    @Bean
    public CompetenceEcritureSerive competenceEcritureSerive(CompetenceDatasource datasource) {
        return new CompetenceEcritureServiceImpl(datasource);
    }
}
