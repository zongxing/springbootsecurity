package com.mashensoft.jpa.dao;

import com.mashensoft.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
//    public List<User> findByUsername(String username);
//    public List<User> findByUsernameAndPassword(String username,String password);
//    public List<User> findByUsernameLike(String username);
//    public List<User> findByUsernameLikeAndPassword(String username,String password);
//    public List<User> findByUsernameLikeOrPassword(String username,String password);
     @Query(value="select * from user  where username=?1",nativeQuery = true)
      List<User> findByName(String username);



//    @Query(value = "select u from user  u where u.username=?1")
//     List<User> findByUsername(String username);
    @Query(value = "select u.* from user  u where u.username=:username",nativeQuery = true)
     List<User> findByUsername2(@Param("username") String username);
////    @Query(value = "select u from user  u where u.username=?1")
    @Modifying
    @Transactional
    @Query(value="insert into user (username,password,age) values(:username,:password,:age)",nativeQuery = true)
    int saveUser(@Param("username") String username,@Param("password") String password,@Param("age") int age);


    /**
     * 修改
     * @param username
     * @param password
     * @param age
     * @return
     */
    @Modifying
//    @Transactional
    @Query(value="update user set username=:username,password=:password,age=:age where userid=:userid",nativeQuery = true)
    int updateUser(@Param("username") String username,@Param("password") String password,@Param("age") int age,@Param("userid") int userid);
    @Modifying
    @Transactional
    @Query(value="delete from user where username=:username",nativeQuery = true)
    int deleteUser(@Param("username") String username);


}
