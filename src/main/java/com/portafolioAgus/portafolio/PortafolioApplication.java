package com.portafolioAgus.portafolio;

import com.portafolioAgus.portafolio.models.*;
import com.portafolioAgus.portafolio.repositories.*;
import com.portafolioAgus.portafolio.security.Enums.RolNombre;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
@Slf4j
public class PortafolioApplication {

	/*
	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	RedesSocialesRepository redesSocialesRepository;

	@Autowired
	SobreMiRepository sobreMiRepository;

	@Autowired
	ServiciosRepository serviciosRepository;

	@Autowired
	CertificacionesRepository certificacionesRepository;

	@Autowired
	ProyectosRepository proyectosRepository;
	*/


	public static void main(String[] args) {
		SpringApplication.run(PortafolioApplication.class, args);
	}

	/*
	@Override
	public void run(String... args) throws Exception {
		Persona agustinaChiodini = new Persona("Agustina", "Chiodini", "Desarrolladora Web Full-Stack java", "C:\\Angular\\Agustina-Angular-Portafolio\\src\\assets\\images\\Image-portfolio-Agustina-Chiodini.png", "Apasionada por proyectos desafiantes. Siempre aprendiendo y creciendo como desarrolladora, me encanta enfrentar nuevos retos y superarlos con creatividad y determinación. Soy una persona comprometida con mi trabajo y busco constantemente mejorar mis habilidades para ofrecer soluciones de calidad a mis clientes.");
		personaRepository.save(agustinaChiodini);

		RedesSociales redesSocialesGitHub = new RedesSociales("<span class=\"iconify\" data-icon=\"octicon:mark-github-16\">", "GitHub", "https://github.com/AgusChio", agustinaChiodini);
		redesSocialesRepository.save(redesSocialesGitHub);
		RedesSociales redesSocialesLinkedIn = new RedesSociales("<span class=\"iconify\" data-icon=\"bi:linkedin\"></span>", "LinkedIn", "https://www.linkedin.com/in/agustina-chiodini/",agustinaChiodini);
		redesSocialesRepository.save(redesSocialesLinkedIn);
		RedesSociales redesSocialesInstagram = new RedesSociales("<span class=\"iconify\" data-icon=\"teenyicons:instagram-solid\">", "Instagram", "https://www.instagram.com/agus.chio/",agustinaChiodini);
		redesSocialesRepository.save(redesSocialesInstagram);

		SobreMi sobreMiAgustinaChiodini = new SobreMi("Como <span class=\"color1\">Desarrolladora Full-Stack en Java</span>, me destaco por mi capacidad para <span class=\"color2\">trabajar en equipo</span> y mi compromiso con el éxito del proyecto. Con mi <span class=\"color1\">formación en MindHub y más de 700 horas</span> de práctica en entornos laborales simulados con <span class=\"color2\">metodologías ágiles SCRUM</span>, puedo adaptarme fácilmente a diferentes desafíos y <span class=\"color1\">asegurar la calidad</span> de las soluciones tecnológicas que desarrollo.","He trabajado con <span class=\"color2\">HTML, CSS, Bootstrap, JavaScript, Vue.js, Spring Framework, PostgreSQL, Postman, Trello y Figma</span>, y los he implementado tanto en proyectos individuales como grupales. Si quieres ver ejemplos de mi trabajo, puedes consultar <a href=\"https://github.com/AgusChio\" class=\"color1\">mi GitHub</a>, donde encontrarás algunos de mis proyectos más recientes y relevantes.","C:\\Angular\\Agustina-Angular-Portafolio\\src\\assets\\pdf\\Agustina-Chiodini.pdf",agustinaChiodini);
		sobreMiRepository.save(sobreMiAgustinaChiodini);

		Servicios servicioFrontEnd = new Servicios("Desarroladora Front-end", "Puedo desarrollar sitios web atractivos, creativos e intereactivos con los usuarios. Utilizando tecnologias como HTML, CSS, Bootstrap, JavaScript y Vue.js", agustinaChiodini);
		serviciosRepository.save(servicioFrontEnd);
		Servicios serviciosBackEnd = new Servicios("Desarrolladora Back-End", "Puedo desarrollar sitios web con seguridad y estables. Utilizando las tecnologias de Java, Spring Framework, Spring Boot, H2 database, PostgreSQL y MySQL(proximamente)", agustinaChiodini);
		serviciosRepository.save(serviciosBackEnd);
		Servicios serviciosFullStack = new Servicios("Desarrolladora Full-Stack", "Puedo desarrollar sitios web aplicando todo lo relacionado anteriormente con el front-end y back-end. Ademas de saber usar hermientas como figma para el diseño y trello para una mejor organizacion.", agustinaChiodini);
		serviciosRepository.save(serviciosFullStack);

		Certificaciones certificacionMindHub = new Certificaciones("Certificado/Insignia MindhubLA - Desarrolladora Full-Stack Java", "MindHubLA", LocalDate.of(2022,10,11), LocalDate.of(2023,2,05), "C:\\Angular\\Agustina-Angular-Portafolio\\src\\assets\\images\\insignia_JAVA.png",agustinaChiodini);
		certificacionesRepository.save(certificacionMindHub);
		Certificaciones certificacionSeProgramar = new Certificaciones("Certificado de Se Programar - Argentina Programa - Aprendiendo Lógica", "Argetina Programa", LocalDate.of(2022,4,11), LocalDate.of(2022,6,11), "C:\\Angular\\Agustina-Angular-Portafolio\\src\\assets\\images\\argentina_programa_2022-1.png", agustinaChiodini);
		certificacionesRepository.save(certificacionSeProgramar);

		Proyectos proyectoMightyDucksHockeyLeague = new Proyectos("Mighty Ducks Hockey League", "C:\\Angular\\Agustina-Angular-Portafolio\\src\\assets\\images\\mightyDucksHockeyLeagueProyect.png", "https://drive.google.com/file/d/1lpn0qQ2XMUs0u_CIR4imPVwfxJf1q5f_/view", "https://github.com/AgusChio/Mighty-Ducks", "https://aguschio.github.io/Mighty-Ducks/", agustinaChiodini);
		proyectosRepository.save(proyectoMightyDucksHockeyLeague);
		Proyectos proyectoParaisoAnimal = new Proyectos("Paraiso Animal - PetShop", "C:\\Angular\\Agustina-Angular-Portafolio\\src\\assets\\images\\paraisoAnimalProyect.png", "https://drive.google.com/file/d/1hewUKYkXBNHT4BpseLRbHEoY8zD2_q90/view" ,"https://github.com/AgusChio/Paraiso-Animal-Petshop", "https://aguschio.github.io/Paraiso-Animal-Petshop/", agustinaChiodini);
		proyectosRepository.save(proyectoParaisoAnimal);
		Proyectos proyectoTheCamp = new Proyectos("The Camp - Cerveceria", "C:\\Angular\\Agustina-Angular-Portafolio\\src\\assets\\images\\theCampProyect.png", "https://drive.google.com/file/d/1TXmbk60XvzYznpSvd3TlX8f1hIs0zOxR/view", "https://github.com/AgusChio/The-Camp", "No tiene deploy",agustinaChiodini);
		proyectosRepository.save(proyectoTheCamp);
		Proyectos proyectoStarbucks = new Proyectos("Starbucks - Pagina Web", "C:\\Angular\\Agustina-Angular-Portafolio\\src\\assets\\images\\statbucksProyect.png", "https://drive.google.com/file/d/1GRn0e1sKXkYJIj7iWngNEFYDyisWf8MW/view", "https://github.com/AgusChio/Starbucks-new-desing", "https://aguschio.github.io/Starbucks-new-desing/",agustinaChiodini);
		proyectosRepository.save(proyectoStarbucks);
		Proyectos proyectoAlfonsinaHomebanking = new Proyectos("Alfonsina Homebanking - Aplicacion web", "C:\\Angular\\Agustina-Angular-Portafolio\\src\\assets\\images\\homebankingProyecto.png", "https://drive.google.com/file/d/1ltME6GdHLtObrBdzd2uZyCYDzb8Z30dQ/view", "https://github.com/AgusChio/Alfonsina-Homebanking", "No tiene deploy", agustinaChiodini);
		proyectosRepository.save(proyectoAlfonsinaHomebanking);

	}
	*/
}
