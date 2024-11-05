package org.example.springdata2k.node;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Node(labels = {"Person", "Actor"})
public class Actor {
  @Id
  private Integer id;
  private String name;
  private int born;
  @Relationship(type="ACTED_IN", direction = Relationship.Direction.OUTGOING)
  private List<Movie> movies;
}
