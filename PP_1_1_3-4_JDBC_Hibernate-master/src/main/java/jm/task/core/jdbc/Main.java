package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.model.dao.UserDao;
import jm.task.core.jdbc.model.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //UserDao userDao = new UserDaoJDBCImpl();

        UserDao userDao = new UserDaoHibernateImpl();
        userDao.createUsersTable();

        userDao.saveUser("Anna", "Fairy", (byte) 15);
        userDao.saveUser("Alice", "Wonderland", (byte) 14);
        userDao.saveUser("Harry", "Potter", (byte) 17);
        userDao.saveUser("Oleg", "Tinkoff", (byte) 54);

        List <User> list = userDao.getAllUsers();
        list.forEach(System.out::println);
        userDao.removeUserById(4);
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
