package question2.dao;

import question2.entity.Transaction;

public class TransactionDao extends BaseDao<Transaction,Long> {
    @Override
    public Class<Transaction> getEntityClass() {
        return Transaction.class;
    }
}
