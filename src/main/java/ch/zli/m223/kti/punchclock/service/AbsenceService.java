package ch.zli.m223.kti.punchclock.service;

import ch.zli.m223.kti.punchclock.domain.Absence;
import ch.zli.m223.kti.punchclock.domain.Entry;
import ch.zli.m223.kti.punchclock.domain.Expense;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class AbsenceService {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public Absence createAbsence(Absence absence) {
        entityManager.persist(absence);
        return absence;
    }

    @SuppressWarnings("unchecked")
    public List<Absence> getAllAbsences() {
        var query = entityManager.createQuery("FROM Absence");
        return query.getResultList();
    }

    @Transactional
    public void deleteAbsence(Long absenceID) {
        var obj = getAbsence(absenceID);
        entityManager.remove(obj);
    }

    public Entry getAbsence(Long absenceId) {
        return entityManager.find(Entry.class, absenceId);
    }
}
