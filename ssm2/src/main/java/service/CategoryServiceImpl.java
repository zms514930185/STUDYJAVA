package service;

import dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Category;
import util.Page;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao cd;

    @Override
    public List<Category> getlist() {
        return cd.list();
    }

//    @Override
//    public List<Category> getlist(Page page) {
////        TODO Auto-generated method stub
//        return cd.list(page);
//    }

//    @Override
//    public int total() {
//        return cd.total();
//    }

    @Override
    public int add(Category category){
    return cd.add(category);
    }
}
