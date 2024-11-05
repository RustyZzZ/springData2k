package org.example.springdata2k;

import org.example.springdata2k.node.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableNeo4jRepositories
public class SpringData2kApplication implements CommandLineRunner {

  @Autowired
  private Neo4jTemplate neo4jTemplate;

  @Autowired
  private ActorRepository actorRepository;

  public static void main(String[] args) {
    SpringApplication.run(SpringData2kApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Actor newActor = new Actor();
    newActor.setId(12331231);
    newActor.setName("John Doe");
    newActor.setBorn(1998);
    List<Actor> actor = actorRepository.findByNameAndBorn("John Doe", 1998);
    Optional<Actor> actor1 = actorRepository.findById(12331231);
    List<Actor> neRostyslavDiachuk = actorRepository.findBySomething("Ne Rostyslav Diachuk");
//    List<Actor> actors = neo4jTemplate.findAll("MATCH (p:Person{name: 'Ne Rostyslav Diachuk'})-[:ACTED_IN]->(m:Movie) RETURN p, m", Actor.class);
  }
}
