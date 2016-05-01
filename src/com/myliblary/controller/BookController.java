package com.myliblary.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myliblary.dao.BookDAO;
import com.myliblary.model.Book;


@Controller
public class BookController {

  	 @Autowired
	 private BookDAO bookDao; 
	 
  	 @RequestMapping(value="/bookList", produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.ALL_VALUE, method = RequestMethod.GET
   		  )
     @ResponseBody
     public List<Book> list() {
         List<Book> bookList = bookDao.list();
         //ModelAndView model = new ModelAndView("BookList");
         //model.addObject("bookList", bookList);
         return bookList;
     }
/*
   @RequestMapping(value="/addBook")
     public ModelAndView add() {
         ModelAndView model = new ModelAndView("BookAdd");
        Book item=new Book();
        model.addObject("item", item);
         List<Book> itemList = userDao.list();
         model.addObject("itemList", itemList);
         return model;
     }

   @RequestMapping(value="/editBook")
     public ModelAndView edit(@RequestParam(value="id", required=true) Long id) {
       System.out.println("Id= " + id);
         ModelAndView model = new ModelAndView("BookAdd");
        Book item=  userDao.getBook(id);
        model.addObject("item", item);
        List<Book> itemList = userDao.list();
         model.addObject("itemList", itemList);
         return model;
     }

   @RequestMapping(value="/deleteBook")
     public ModelAndView delete(@RequestParam(value="id", required=true) int id) {
         ModelAndView model = new ModelAndView("BookAdd");
         userDao.deleteBook(id);
        List<Book> itemList = userDao.list();
         model.addObject("itemList", itemList);
         return model;
     }

   @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
     public ModelAndView save(@ModelAttribute("book") Book item) {
         System.out.println(item.getTitle());
         if(null != item )
             userDao.add(item);

         ModelAndView model = new ModelAndView("BookAdd");
         item=new Book();
         model.addObject("book", item);
         List<Book> itemList = userDao.list();
         model.addObject("itemList", itemList);
         return model;
   }

   @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
     public ModelAndView update(@ModelAttribute("item") Book item) {
         System.out.println(item.getTitle());
         if(null != item )
             userDao.update(item);

         ModelAndView model = new ModelAndView("BookAdd");
         item=new Book();
         model.addObject("item", item);
         List<Book> itemList = userDao.list();
         model.addObject("itemList", itemList);
         return model;
   }
 */

}
