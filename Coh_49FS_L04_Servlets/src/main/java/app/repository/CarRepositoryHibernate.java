package app.repository;

import app.model.Car;
import jakarta.persistence.EntityManager;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @author Sergey Bugaenko
 * {@code @date} 06.12.2024
 */

public class CarRepositoryHibernate implements CarRepository {

    EntityManager entityManager;

    public CarRepositoryHibernate() {
        entityManager = new Configuration()
                .configure("hibernate/postgres.cfg.xml")
                .buildSessionFactory().createEntityManager();
    }

    @Override
    public List<Car> getAll() {
        return entityManager.createQuery("from Car", Car.class).getResultList();
    }

    @Override
    public Car getById(long id) {
        return entityManager.find(Car.class, id);
    }

    @Override
    public Car save(Car car) {
        return null;
    }

    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
