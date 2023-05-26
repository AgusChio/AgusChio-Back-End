package com.portafolioAgus.portafolio;

import com.portafolioAgus.portafolio.Utils.Enums.TypeSkills;
import com.portafolioAgus.portafolio.entity.*;
import com.portafolioAgus.portafolio.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class PortafolioApplication {

//	@Autowired
//	PersonaRepository personaRepository;
//
//	@Autowired
//	SkillRepository skillRepository;
//
//	@Autowired
//	SobreMiRepository sobreMiRepository;
//
//	@Autowired
//	ServiciosRepository serviciosRepository;
//
//	@Autowired
//	EducacionRepository educacionRepository;
//
//	@Autowired
//	ProyectosRepository proyectosRepository;


	public static void main(String[] args) {
		SpringApplication.run(PortafolioApplication.class, args);
	}


	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "https://cheerful-dolphin-8f9864.netlify.app/"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

//	@Bean
//	public CommandLineRunner initData() {
//		return (args) -> {
//
//			Persona agustinaChiodini = new Persona("Agustina", "Chiodini", "Desarrolladora Web Full-Stack java", "https://res.cloudinary.com/dhcurgqlc/image/upload/v1683826202/Image-portfolio-Agustina-Chiodini_hxyltd.png","https://res.cloudinary.com/dhcurgqlc/image/upload/v1683929095/191d24_n0rfmk.png", "Apasionada por proyectos desafiantes. Siempre aprendiendo y creciendo como desarrolladora, me encanta enfrentar nuevos retos y superarlos con creatividad y determinación. Soy una persona comprometida con mi trabajo y busco constantemente mejorar mis habilidades para ofrecer soluciones de calidad a mis clientes.");
//			personaRepository.save(agustinaChiodini);
//
//			SobreMi sobreMiAgustinaChiodini = new SobreMi("Como Desarrolladora Full-Stack en Java, me destaco por mi capacidad para trabajar en equipo</span> y mi compromiso con el éxito del proyecto. Con mi formación en MindHub y más de 700 horas de práctica en entornos laborales simulados con metodologías ágiles SCRUM, puedo adaptarme fácilmente a diferentes desafíos y asegurar la calidad</span> de las soluciones tecnológicas que desarrollo.", "He trabajado con HTML, CSS, Bootstrap, JavaScript, Vue.js, Spring Framework, PostgreSQL, Postman, Trello y Figma, y los he implementado tanto en proyectos individuales como grupales. Si quieres ver ejemplos de mi trabajo, puedes consultar mi GitHub, donde encontrarás algunos de mis proyectos más recientes y relevantes.", "https://res.cloudinary.com/dhcurgqlc/image/upload/v1683929382/Agustina-Chiodini_page-0001_y4slaq.jpg", agustinaChiodini);
//			sobreMiRepository.save(sobreMiAgustinaChiodini);
//
//			Skills skillsHTML = new Skills("HTML", 80, "Ya se la pondre", "#f59b71", "#f27d46", TypeSkills.HARD, agustinaChiodini);
//			skillRepository.save(skillsHTML);
//			Skills skillsCSS = new Skills("CSS", 80, "Ya se la pondre", "#ff7474", "#fc4c4c", TypeSkills.HARD, agustinaChiodini);
//			skillRepository.save(skillsCSS);
//			Skills skillsBOOTSTRAP = new Skills("BOOTSTRAP", 70, "Ya se la pondre", "#63ccca", "#16c7c4", TypeSkills.HARD, agustinaChiodini);
//			skillRepository.save(skillsBOOTSTRAP);
//			Skills skillsJAVASCRIPT = new Skills("JAVASCRIPT", 70, "Ya se la pondre", "#f59b71", "#f27d46", TypeSkills.HARD, agustinaChiodini);
//			skillRepository.save(skillsJAVASCRIPT);
//			Skills skillsTYPESCRIPT = new Skills("TYPESCRIPT", 70, "Ya se la pondre", "#ff7474", "#fc4c4c", TypeSkills.HARD, agustinaChiodini);
//			skillRepository.save(skillsTYPESCRIPT);
//			Skills skillsVUE = new Skills("VUE.JS", 70, "Ya se la pondre", "#63ccca", "#16c7c4", TypeSkills.HARD, agustinaChiodini);
//			skillRepository.save(skillsVUE);
//			Skills skillsANGULAR = new Skills("ANGULAR", 70, "Ya se la pondre", "#f59b71", "#f27d46", TypeSkills.HARD, agustinaChiodini);
//			skillRepository.save(skillsANGULAR);
//			Skills skillsFIGMA = new Skills("FIGMA", 60, "Ya se la pondre", "#ff7474", "#fc4c4c", TypeSkills.HARD, agustinaChiodini);
//			skillRepository.save(skillsFIGMA);
//			Skills skillsTRELLO = new Skills("TRELLO", 100, "Ya se la pondre", "#63ccca", "#16c7c4", TypeSkills.HARD, agustinaChiodini);
//			skillRepository.save(skillsTRELLO);
//			Skills skillsSPRING = new Skills("SPRING", 70, "Ya se la pondre", "#f59b71", "#f27d46", TypeSkills.HARD, agustinaChiodini);
//			skillRepository.save(skillsSPRING);
//			Skills skillsJAVA = new Skills("JAVA", 80, "Ya se la pondre", "#ff7474", "#fc4c4c", TypeSkills.HARD, agustinaChiodini);
//			skillRepository.save(skillsJAVA);
//			Skills skillsPOSTGRESQL = new Skills("POSTGRESQL", 80, "Ya se la pondre", "#63ccca", "#16c7c4", TypeSkills.HARD, agustinaChiodini);
//			skillRepository.save(skillsPOSTGRESQL);
//			Skills skillsMYSQL = new Skills("MYSQL", 80, "Ya se la pondre", "#f59b71", "#f27d46", TypeSkills.HARD, agustinaChiodini);
//			skillRepository.save(skillsMYSQL);
//			Skills skillsPOSTMAN = new Skills("POSTMAN", 100, "Ya se la pondre", "#ff7474", "#fc4c4c", TypeSkills.HARD, agustinaChiodini);
//			skillRepository.save(skillsPOSTMAN);
//			Skills skillsGITHUB = new Skills("GITHUB", 80, "Ya se la pondre", "#63ccca", "#16c7c4", TypeSkills.HARD, agustinaChiodini);
//			skillRepository.save(skillsGITHUB);
//			Skills skillsGIT = new Skills("GIT", 80, "Ya se la pondre", "#f59b71", "#f27d46", TypeSkills.HARD, agustinaChiodini);
//			skillRepository.save(skillsGIT);
//			Skills skillsEMPATICA = new Skills("EMPATICA", 100, "Ya se la pondre", "#ff7474", "#fc4c4c", TypeSkills.SOFT, agustinaChiodini);
//			skillRepository.save(skillsEMPATICA);
//			Skills skillsTRABAJOENEQUIPO = new Skills("TRABAJO EN EQUIPO", 100, "Ya se la pondre", "#63ccca", "#16c7c4", TypeSkills.SOFT, agustinaChiodini);
//			skillRepository.save(skillsTRABAJOENEQUIPO);
//			Skills skillsSOLUCION = new Skills("SOLUCION CREATIVA DE PROBLEMAS", 100, "Ya se la pondre", "#f59b71", "#f27d46", TypeSkills.SOFT, agustinaChiodini);
//			skillRepository.save(skillsSOLUCION);
//			Skills skillsFELIXIILIDAD = new Skills("FELIXIILIDAD Y ADAPTABILIDAD", 100, "Ya se la pondre", "#ff7474", "#fc4c4c", TypeSkills.SOFT, agustinaChiodini);
//			skillRepository.save(skillsFELIXIILIDAD);
//			Skills skillsGESTIONDETIEMPO = new Skills("GESTION DE TIEMPO", 100, "Ya se la pondre", "#63ccca", "#16c7c4", TypeSkills.SOFT, agustinaChiodini);
//			skillRepository.save(skillsGESTIONDETIEMPO);
//			Skills skillsRESPONSABILIDAD = new Skills("RESPONSABILIDAD ETICA", 100, "Ya se la pondre", "#f59b71", "#f27d46", TypeSkills.SOFT, agustinaChiodini);
//			skillRepository.save(skillsRESPONSABILIDAD);
//
//
//			Servicios servicioFrontEnd = new Servicios("Desarroladora Front-end", "Puedo desarrollar sitios web atractivos, creativos e intereactivos con los usuarios. Utilizando tecnologias como HTML, CSS, Bootstrap, JavaScript y Vue.js", agustinaChiodini);
//			serviciosRepository.save(servicioFrontEnd);
//			Servicios serviciosBackEnd = new Servicios("Desarrolladora Back-End", "Puedo desarrollar sitios web con seguridad y estables. Utilizando las tecnologias de Java, Spring Framework, Spring Boot, H2 database, PostgreSQL y MySQL(proximamente)", agustinaChiodini);
//			serviciosRepository.save(serviciosBackEnd);
//			Servicios serviciosFullStack = new Servicios("Desarrolladora Full-Stack", "Puedo desarrollar sitios web aplicando todo lo relacionado anteriormente con el front-end y back-end. Ademas de saber usar hermientas como figma para el diseño y trello para una mejor organizacion.", agustinaChiodini);
//			serviciosRepository.save(serviciosFullStack);
//
//			Educacion certificacionMindHub = new Educacion("Certificado/Insignia MindhubLA - Desarrolladora Full-Stack Java", "MindHubLA", "2022-10-11", "2023-02-05", "https://res.cloudinary.com/dhcurgqlc/image/upload/v1683863309/insignia_JAVA_cxpb1z.png", agustinaChiodini);
//			educacionRepository.save(certificacionMindHub);
//			Educacion certificacionSeProgramar = new Educacion("Certificado de Se Programar - Argentina Programa - Aprendiendo Lógica", "Argetina Programa", "2022-4-11", "2022-6-11", "https://res.cloudinary.com/dhcurgqlc/image/upload/v1683863267/argentina_programa_2022-1_mmgc6w.png", agustinaChiodini);
//			educacionRepository.save(certificacionSeProgramar);
//
//			Proyectos proyectoMightyDucksHockeyLeague = new Proyectos("Mighty Ducks Hockey League", "https://res.cloudinary.com/dhcurgqlc/image/upload/v1683863339/mightyDucksHockeyLeagueProyect_kjmeyr.png","Mi primer Proyecto estático donde aprendi las bases de desarrollo web y a como usarlas, utilice las tecnologias de HTML Y CSS." , "2022-10-24" , "https://drive.google.com/file/d/1lpn0qQ2XMUs0u_CIR4imPVwfxJf1q5f_/view", "https://github.com/AgusChio/Mighty-Ducks", "https://aguschio.github.io/Mighty-Ducks/", agustinaChiodini);
//			proyectosRepository.save(proyectoMightyDucksHockeyLeague);
//			Proyectos proyectoParaisoAnimal = new Proyectos("Paraiso Animal - PetShop", "https://res.cloudinary.com/dhcurgqlc/image/upload/v1683863337/paraisoAnimalProyect_eadq4z.png", "Este fue un proyecto grupal llamado challeng Petshop, donde se trabajo solo parte del front-end consumiendo una API, usando HTML, CSS y JS(fetch).", "2022-12-11" ,"https://drive.google.com/file/d/1hewUKYkXBNHT4BpseLRbHEoY8zD2_q90/view", "https://github.com/AgusChio/Paraiso-Animal-Petshop", "https://aguschio.github.io/Paraiso-Animal-Petshop/", agustinaChiodini);
//			proyectosRepository.save(proyectoParaisoAnimal);
//			Proyectos proyectoTheCamp = new Proyectos("The Camp - Cerveceria", "https://res.cloudinary.com/dhcurgqlc/image/upload/v1683863340/theCampProyect_vuem1i.png", "Este es otro proyecto grupal llamado Challenge Final donde se trabajo front-end usando HTML, CSS, VUE.JS(AXIOS), BOOTSTRAP y en el back-end usando JAVA, SPRING, SPRING BOOT, HIBERNATE, SPRING SECURITY, POSTGRESQL, entre otras cosas.", "2023-01-16", "https://drive.google.com/file/d/1TXmbk60XvzYznpSvd3TlX8f1hIs0zOxR/view", "https://github.com/AgusChio/The-Camp", "No tiene deploy", agustinaChiodini);
//			proyectosRepository.save(proyectoTheCamp);
//			Proyectos proyectoStarbucks = new Proyectos("Starbucks - Pagina Web","https://res.cloudinary.com/dhcurgqlc/image/upload/v1683863337/statbucksProyect_wcfkzk.png","Este es un proyecto solo de Front-end el cual me falta terminar, en este use las tecnologias de HTML, CSS, BOOTSTRAP, JS(EMAIL.JS)", "2023-03-20", "https://drive.google.com/file/d/1GRn0e1sKXkYJIj7iWngNEFYDyisWf8MW/view?usp=share_link", "https://github.com/AgusChio/Starbucks-new-desing", "https://aguschio.github.io/Starbucks-new-desing/", agustinaChiodini);
//			proyectosRepository.save(proyectoStarbucks);
//			Proyectos proyectoAlfonsinaHomebanking = new Proyectos("Alfonsina Homebanking - Aplicacion web", "https://res.cloudinary.com/dhcurgqlc/image/upload/v1683863295/homebankingProyecto_eaxepe.png", "Es un proyecto totalmente hecho por mi tanto como en front-end donde utilice HTML, CSS, VUE.JS(AXIOS), BOOTSTAP, y en el back-end JAVA, SPRING, SPRING BOOT, HIBERNATE, SPRING SECURITY, POSTGRESQL, entre otras cosas." , "2023-1-29","https://drive.google.com/file/d/1ltME6GdHLtObrBdzd2uZyCYDzb8Z30dQ/view", "https://github.com/AgusChio/Alfonsina-Homebanking", "No tiene deploy", agustinaChiodini);
//			proyectosRepository.save(proyectoAlfonsinaHomebanking);
//
//		};
//	}
}
