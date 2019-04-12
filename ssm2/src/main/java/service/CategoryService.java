package service;

import pojo.Category;
import util.Page;

import java.util.List;

public interface CategoryService {
    List<Category> getlist();
//    List<Category> getlist(Page page);
//    int total();
    int add(Category category);
}
