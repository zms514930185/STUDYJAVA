package dao;

import org.springframework.stereotype.Repository;
import pojo.Category;
import util.Page;

import java.util.List;

@Repository
public interface CategoryDao {
    int add(Category category);
    void delete(Integer id);
    Category get(Integer id);
    int update(Category category);

    List<Category> list();
//    List<Category> list(Page page);
//    int total();
}
