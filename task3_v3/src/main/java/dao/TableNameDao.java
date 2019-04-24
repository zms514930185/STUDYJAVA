package dao;

import org.springframework.stereotype.Repository;
import pojo.TableName;

@Repository
public interface TableNameDao {
    int selectByExample(TableName tableName);
}
