package pl.Maciejjjjj.model.dao;

import org.hibernate.SessionFactory;
import pl.Maciejjjjj.model.entities.Source;

import java.util.List;

public class SourceDao extends BaseDao {

    public SourceDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Source get(Long id) {
        return super.produceInTransaction(session -> session.get(Source.class, id));
    }

    public void save(Source source) {
        super.executeInTransaction(session -> session.save(source));
    }

    public void update(Source source) {
        super.executeInTransaction(session -> session.update(source));
    }

    public void delete(Source source) {
        super.executeInTransaction(session -> session.delete(source));
    }

    public List<Source> getAll() {
        return super.produceInTransaction(
                session -> session.createQuery("SELECT sr FROM Source sr", Source.class)
                        .getResultList());
    }
}
