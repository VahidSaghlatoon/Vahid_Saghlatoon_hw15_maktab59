package question2.manager;

import question2.dao.AccountDao;
import question2.entity.Account;

public class AccountManager extends BaseManager<Account,Long> {
    public AccountManager() {
        setBaseDao(new AccountDao());
    }
}
