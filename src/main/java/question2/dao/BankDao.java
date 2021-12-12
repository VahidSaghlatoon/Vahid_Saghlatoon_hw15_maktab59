package question2.dao;

import question2.entity.Bank;

public class BankDao extends BaseDao<Bank,Long> {
    @Override
    public Class<Bank> getEntityClass() {
        return Bank.class;
    }
}
