package ch.zli.m223.kti.punchclock.service;

import ch.zli.m223.kti.punchclock.domain.Expense;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ExpenseService {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public Expense createExpense(Expense expense) {
        entityManager.persist(expense);
        return expense;
    }

    @SuppressWarnings("unchecked")
    public List<Expense> getAllExpenses() {
        var query = entityManager.createQuery("FROM Expense");
        return query.getResultList();
    }

    @Transactional
    public void deleteExpense(Long expenseId) {
        var obj = getExpense(expenseId);
        entityManager.remove(obj);
    }

    @Transactional
    public Expense update(Expense expense) {
        entityManager.merge(expense);
        return expense;
    }

    public Expense getExpense(Long expenseId) {
        return entityManager.find(Expense.class, expenseId);
    }

    public List getExpensesOver50() {
        Query q = entityManager.createQuery("FROM Expense GROUP BY amount HAVING SUM(amount) > 50.0");
        return q.getResultList();
    }

}
