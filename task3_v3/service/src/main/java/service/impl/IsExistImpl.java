package service.impl;

import dao.TableNameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.TableName;
import service.IsExist;

@Service
public class IsExistImpl implements IsExist {

    @Autowired
    TableNameDao tableNameDao;

    public boolean exist(TableName tableName) {
        int i=tableNameDao.selectByExample(tableName);
        if (0!=i){
            return true;
        }
        return false;
    }
}
