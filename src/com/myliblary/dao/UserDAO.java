package com.myliblary.dao;

import java.util.List;
import com.myliblary.model.User;

public interface UserDAO {

    public List<User> list();
    public void add(User item);
    public void  update(User item);
    public User  getItem(Long id);
    public void  delete(int id);
	
}
