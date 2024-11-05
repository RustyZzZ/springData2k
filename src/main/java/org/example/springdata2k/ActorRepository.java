package org.example.springdata2k;

import org.example.springdata2k.node.Actor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActorRepository extends Neo4jRepository<Actor, Integer> {

  List<Actor> findByNameAndBorn(String name, int born);
  @Query("MATCH (p:Person{name: $name})-[:ACTED_IN]->(m:Movie) RETURN p, m")
  List<Actor> findBySomething(@Param("name")String name);
  @Query("CREATE (p:Person&Actor {name: $actor.name})")
  void insertActor(Actor actor);


}
