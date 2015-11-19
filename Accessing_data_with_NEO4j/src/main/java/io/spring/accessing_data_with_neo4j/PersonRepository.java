
package io.spring.accessing_data_with_neo4j;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;



public interface PersonRepository extends CrudRepository<Person, String>{

    Person findByName(String name);
    
    Iterable<Person> findByTeammatesName(String name);
    
    
}
