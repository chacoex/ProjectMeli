package com.mercadolibre.demo.services;

import com.mercadolibre.demo.entities.Stats;
import com.mercadolibre.demo.repositories.StatsRepository;
import com.mercadolibre.demo.utilitis.CheckMatrixUtils;
import com.mercadolibre.demo.utilitis.ComparatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantService {

    @Autowired
    private StatsRepository statsRepository;

    public boolean isMutant(String[] dna) throws Exception {

        String decodeDna = CheckMatrixUtils.convertToString(dna,",");
        Stats stats = new Stats(0,1, decodeDna);

        int mutantDna = 0;

        try {
            CheckMatrixUtils.checkMatrix(dna);

            for (int i = 0; i < dna.length; i++) {
                for (int j = 0; j < dna[i].length(); j++) {

                    // Validar filas
                    if (j < dna[i].length() - 3) {

                        if (ComparatorUtils.areEqualDna(dna[i].charAt(j), dna[i].charAt(j + 1), dna[i].charAt(j + 2),
                                dna[i].charAt(j + 3))) {
                            mutantDna++;
                        }
                    }

                    // validar columnas
                    if (i < dna[i].length() - 3) {
                        if (ComparatorUtils.areEqualDna(dna[i].charAt(j), dna[i + 1].charAt(j), dna[i + 2].charAt(j),
                                dna[i + 3].charAt(j))) {
                            mutantDna++;
                        }
                    }

                    // validar Derecha a izquierda & Arriba a abajo
                    if (j < dna[i].length() - 3 && i < dna[i].length() - 3) {
                        if (ComparatorUtils.areEqualDna(dna[i].charAt(j), dna[i + 1].charAt(j + 1),
                                dna[i + 2].charAt(j + 2), dna[i + 3].charAt(j + 3))) {
                            mutantDna++;
                        }
                    }

                    // Validar Izquierda a derecha & Abajo a arriba en diagonales
                    if (dna[i].length() > 3 && j < dna[i].length() - 3 && i > 2) {
                        if (ComparatorUtils.areEqualDna(dna[i].charAt(j), dna[i - 1].charAt(j + 1),
                                dna[i - 2].charAt(j + 2), dna[i - 3].charAt(j + 3))) {
                            mutantDna++;
                        }
                    }

                    if (mutantDna >= 2) {
                        stats = new Stats(1,0,decodeDna);
                        statsRepository.save(stats);
                        return true;
                    }
                }

            }

        } catch (Exception e) {
            throw e;
        }
        statsRepository.save(stats);
        return false;

    }

    public Stats getStats() {

        Stats stats = statsRepository.countStats();


        return new Stats(0,stats.getCount_mutant_dna(), stats.getCount_human_dna());
    }
}
