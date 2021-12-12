package question2.dao;

import question2.entity.CreditCard;

public class CreditCardDao extends BaseDao<CreditCard, Long> {
    @Override
    public Class<CreditCard> getEntityClass() {
        return CreditCard.class;
    }
}
