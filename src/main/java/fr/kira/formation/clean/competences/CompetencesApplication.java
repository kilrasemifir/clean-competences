package fr.kira.formation.clean.competences;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kira.formation.clean.competences.infra.CompetenceDatasourceMongoAdapter;
import fr.kira.formation.clean.competences.infra.CompetenceRepository;
import fr.kira.formation.clean.competences.usecases.competences.CompetenceDatasource;
import fr.kira.formation.clean.competences.usecases.competences.CompetenceEcritureSerive;
import fr.kira.formation.clean.competences.usecases.competences.CompetenceLectureService;
import fr.kira.formation.clean.competences.usecases.competences.impl.CompetenceEcritureServiceImpl;
import fr.kira.formation.clean.competences.usecases.competences.impl.CompetenceLectureServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CompetencesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompetencesApplication.class, args);
	}

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
