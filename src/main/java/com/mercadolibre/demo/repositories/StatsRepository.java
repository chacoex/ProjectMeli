package com.mercadolibre.demo.repositories;

import com.mercadolibre.demo.entities.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StatsRepository extends JpaRepository<Stats,String> {

    @Query(value = "SELECT count(id) as id, sum(COUNT_MUTANT_DNA) as count_mutant_dna,sum(COUNT_HUMAN_DNA) as count_human_dna, count(ratio) as ratio, '' as secuencie_dna FROM ADN", nativeQuery = true)
    Stats countStats();
}
