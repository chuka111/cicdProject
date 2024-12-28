package ie.atu.transactionapplication;

import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final AccountClient accountClient;

    public TransactionService(AccountClient accountClient) {
        this.accountClient = accountClient;
    }

    public void transfer(Long fromAccount, Long toAccount, Double amount) {
        Account from = accountClient.getAccount(String.valueOf(fromAccount));
        Account to = accountClient.getAccount(String.valueOf(toAccount));

        if (from == null || to == null) {
            throw new IllegalArgumentException("One or both accounts do not exist.");
        }

        if (from.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance in the source account.");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        accountClient.updateBalance(from);
        accountClient.updateBalance(to);
    }
}
