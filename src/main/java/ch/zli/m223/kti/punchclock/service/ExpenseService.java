package ch.zli.m223.kti.punchclock.service;

import ch.zli.m223.kti.punchclock.domain.Entry;
import ch.zli.m223.kti.punchclock.domain.Expense;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class ExpenseService {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public Expense createExpense(Expense expense) {
        entityManager.persist(expense);
        return expense;
    }

}
