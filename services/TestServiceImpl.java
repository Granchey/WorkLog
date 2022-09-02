package services;

import dao.TestDao;
import dto.UserDto;
import models.User;

import javax.inject.Inject;

public class TestServiceImpl implements TestService{

    private TestDao testDao;

    @Inject
    public TestServiceImpl(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = testDao.getUser(email);
        return user;
    }
}
