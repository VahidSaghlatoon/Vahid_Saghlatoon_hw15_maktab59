package question2.dao;

import question2.entity.Account;

public class AccountDao extends BaseDao<Account,Long> {
    @Override
    public Class<Account> getEntityClass() {
        return Account.class;
    }
}
