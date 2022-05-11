package com.mercadolibre.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "ADN")
public class Stats {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "count_mutant_dna")
    private double count_mutant_dna;
    @Column(name = "count_human_dna")
    private double count_human_dna;
    @Column(name = "secuencie_dna")
    private String secuencie_dna;
    private double ratio;

    public double getCount_mutant_dna() {
        return count_mutant_dna;
    }

    public double getCount_human_dna() {
        return count_human_dna;
    }

    public double getRatio() {
        return ratio;
    }

    public Integer getId() {
        return id;
    }

    public String getSecuencie_adn() {
        return secuencie_dna;
    }

    public Stats() {
    }

    public Stats(double count_mutant_dna, double count_human_dna, String secuencie_dna) {
        this.count_mutant_dna = count_mutant_dna;
        this.count_human_dna = count_human_dna;
        this.secuencie_dna = secuencie_dna;
    }

    public Stats(Integer id, double count_mutant_dna, double count_human_dna) {
        super();
        this.id = id;
        this.count_mutant_dna = count_mutant_dna;
        this.count_human_dna = count_human_dna;

        if (count_mutant_dna == 0 && count_human_dna == 0) {
            this.ratio = 0.0;
        } else {
            if (count_human_dna == 0) {
                this.ratio = 1;
            } else {
                this.ratio = Math.round((count_mutant_dna / count_human_dna) * 10) / 10.0;
            }
        }

    }

}
