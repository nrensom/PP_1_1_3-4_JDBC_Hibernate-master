package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService us = new UserServiceImpl();
        us.createUsersTable();

        us.saveUser("Anna", "Fairy", (byte) 15);
        us.saveUser("Alice", "Wonderland", (byte) 14);
        us.saveUser("Harry", "Potter", (byte) 17);
        us.saveUser("Oleg", "Tinkoff", (byte) 54);

        List <User> list = us.getAllUsers();
        list.forEach(System.out::println);
        us.removeUserById(4);
        us.cleanUsersTable();
        us.dropUsersTable();
    }
}
