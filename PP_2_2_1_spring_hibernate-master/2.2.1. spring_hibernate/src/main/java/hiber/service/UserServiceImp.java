package hiber.service;

import com.mysql.cj.xdevapi.SessionFactory;
import hiber.config.AppConfig;
import hiber.dao.CarDao;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.util.List;

@Service
public class UserServiceImp implements UserService {


   private LocalSessionFactoryBean sessionFactory;

   @Autowired
   private UserDao userDao;

   @Autowired
   private CarDao carDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional
   @Override
   public void add(Car car) {
      carDao.add(car);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional(readOnly = true)
   @Override
   public List<Car> listCars() {
      return carDao.listCars();
   }

   @Transactional(readOnly = true)
   public List<User> getUserByCar(int series, String model) {
      return userDao.getUserByCar(series, model);
   }

}
