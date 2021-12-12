package question2.manager;

import question2.dao.BankDao;
import question2.dao.BaseDao;
import question2.dao.TransactionDao;
import question2.entity.Transaction;

public class TransactionManager extends BaseManager<Transaction,Long>{
    public TransactionManager() {
        setBaseDao(new TransactionDao());
    }
}
