package io.spring.accessing_data_with_neo4j;

import java.util.HashSet;
import java.util.Set;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity // When Neo4j stores it, it results in the creation of a new node
public class Person {

    @GraphId // Neo4j uses @GraphId internally to track the data. 
    Long id;
    public String name;

    //RelatedTo means that every member of this set is expected to also exist as a separate Person node
    @RelatedTo(type = "TEAMMATE", direction = Direction.BOTH)
    public @Fetch //This causes the teammates to be eagerly retrieved. Otherwise use neo4jTemplate.fetch().
    Set<Person> teammates;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void worksWith(Person person) {
        if (teammates == null) {
            teammates = new HashSet<Person>();
        }
        teammates.add(person);
    }

    @Override
    public String toString() {
        String results = name + "'s teammates include\n";
        if (teammates != null) {
            for (Person person : teammates) {
                results += "\t- " + person.name + "\n";
            }
        }
        return results;
    }

}
