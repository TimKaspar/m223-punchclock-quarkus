package ch.zli.m223.kti.punchclock.service;

import ch.zli.m223.kti.punchclock.domain.Absence;
import ch.zli.m223.kti.punchclock.domain.Expense;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class AbsenceService {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public Absence createAbsence(Absence absence) {
        entityManager.persist(absence);
        return absence;
    }
}
