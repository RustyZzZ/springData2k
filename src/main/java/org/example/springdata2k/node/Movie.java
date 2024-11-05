package org.example.springdata2k.node;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node("Movie")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Movie {
  @Id
  private Integer id;
  private String title;
  @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
  private List<Actor> actors;
}
