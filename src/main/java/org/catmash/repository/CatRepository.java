package org.catmash.repository;

import java.util.Set;

import org.catmash.datamodel.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, String> {

  /**
   * Get two random cats
   * 
   * @return A set of two random cats
   */
  @Query(value = "SELECT * FROM Cat ORDER BY RAND() LIMIT 2", nativeQuery = true)
  Set<Cat> findCatRandom();
}
