package ch.zli.m223.kti.punchclock.service;

import ch.zli.m223.kti.punchclock.domain.Entry;
import ch.zli.m223.kti.punchclock.domain.Expense;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class ExpenseService {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public Expense createExpense(Expense expense) {
        entityManager.persist(expense);
        return expense;
    }

    @SuppressWarnings("unchecked")
    public List<Expense> findAll() {
        var query = entityManager.createQuery("FROM Expense");
        return query.getResultList();
    }

    @Transactional
    public void deleteExpense(Long expenseId) {
        var obj = getExpense(expenseId);
        entityManager.remove(obj);
    }

}
