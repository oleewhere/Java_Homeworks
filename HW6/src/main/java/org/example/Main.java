package org.example;

import org.example.auto.*;
import org.example.tab.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            sessionFactory.inTransaction(session -> {
                session.persist(new Word("Hello"));
                session.persist(new Word("Apple"));
                session.persist(new Word("Berry"));
                session.persist(new Word("PC"));

                Car car = Car.builder()
                        .model("Audi A6")
                        .type(Type.SEDAN)
                        .power(245)
                        .price(42000.0)
                        .year(2020)
                        .build();

                session.persist(car);
            });

            try (var session = sessionFactory.openSession()) {
                List<String> valuesList = session
                        .createQuery("select w.value from Word w", String.class)
                        .list();

                System.out.println("Result list: " + valuesList);
            }
        }
    }
}