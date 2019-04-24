package service.impl;

import dao.TableNameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.TableName;
import service.TableNameService;

@Service
public class TableNameServiceImpl implements TableNameService {
    @Autowired
    TableNameDao tableNameDao;
    public int selectByExample(TableName tableName) {
        return tableNameDao.selectByExample(tableName);
    }

//    public  boolean exist(TableName tableName){
//
//        int i=tableNameDao.selectByExample(tableName);
//        if (0==i){
//            return false;
//        }
//        return true;
//    }

}
