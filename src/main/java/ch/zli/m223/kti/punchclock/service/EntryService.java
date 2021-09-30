package ch.zli.m223.kti.punchclock.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.kti.punchclock.domain.Entry;

//@Authenticated
@ApplicationScoped
public class EntryService {
    @Inject
    private EntityManager entityManager;

    public EntryService() {
    }

    @Transactional
    public Entry createEntry(Entry entry) {
        entityManager.persist(entry);
        return entry;
    }

    @SuppressWarnings("unchecked")
    public List<Entry> getAllEntries() {
        var query = entityManager.createQuery("FROM Entry");
        return query.getResultList();
    }

    @Transactional
    public void deleteEntry(Long entryId) {
        var obj = getEntry(entryId);
        entityManager.remove(obj);
    }

    @Transactional
    public Entry update(Entry entry) {
        entityManager.merge(entry);
        return entry;
    }

    public Entry getEntry(Long entryId) {
        return entityManager.find(Entry.class, entryId);
    }
}
