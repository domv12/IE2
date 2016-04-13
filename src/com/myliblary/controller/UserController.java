package com.myliblary.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myliblary.dao.UserDAO;
import com.myliblary.model.User;
 
@Controller
public class UserController {
 
    @Autowired
    private UserDAO userDao; 
 
      @RequestMapping(value="/list")
        public ModelAndView list() {
            List<User> itemList = userDao.list();
            ModelAndView model = new ModelAndView("UserList");
            model.addObject("itemList", itemList);
            return model;
        }
 
      @RequestMapping(value="/")
        public ModelAndView add() {
            ModelAndView model = new ModelAndView("UserAdd");
           User item=new User();
           model.addObject("item", item);
            List<User> itemList = userDao.list();
            model.addObject("itemList", itemList);
            return model;
        }
 
      @RequestMapping(value="/edit")
        public ModelAndView edit(@RequestParam(value="id", required=true) Long id) {
          System.out.println("Id= " + id);
            ModelAndView model = new ModelAndView("UserAdd");
           User item=  userDao.getItem(id);
           model.addObject("item", item);
           List<User> itemList = userDao.list();
            model.addObject("itemList", itemList);
            return model;
        }
 
      @RequestMapping(value="/delete")
        public ModelAndView delete(@RequestParam(value="id", required=true) int id) {
            ModelAndView model = new ModelAndView("UserAdd");
            userDao.delete(id);
           List<User> itemList = userDao.list();
            model.addObject("itemList", itemList);
            return model;
        }
 
      @RequestMapping(value = "/save", method = RequestMethod.POST)
        public ModelAndView save(@ModelAttribute("user") User item) {
            System.out.println(item.getLastName());
            if(null != item )
                userDao.add(item);
 
            ModelAndView model = new ModelAndView("UserAdd");
            item=new User();
            model.addObject("user", item);
            List<User> itemList = userDao.list();
            model.addObject("itemList", itemList);
            return model;
      }
 
      @RequestMapping(value = "/update", method = RequestMethod.POST)
        public ModelAndView update(@ModelAttribute("item") User item) {
            System.out.println(item.getLastName());
            if(null != item )
                userDao.update(item);
 
            ModelAndView model = new ModelAndView("UserAdd");
            item=new User();
            model.addObject("item", item);
            List<User> itemList = userDao.list();
            model.addObject("itemList", itemList);
            return model;
      }
 
}