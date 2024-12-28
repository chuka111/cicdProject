package ie.atu.transactionapplication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@FeignClient(name = "account-service", url = "http://localhost:8081/accounts")
public interface AccountClient {
/*    private final RestTemplate restTemplate;

    public AccountClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Account getAccount(String accountNumber) {
        return restTemplate.getForObject("http://ACCOUNT-SERVICE/accounts/" + accountNumber, Account.class);
    }

    public void updateAccount(Account account) {
        restTemplate.put("http://ACCOUNT-SERVICE/accounts/" + account.getAccountNumber(), account);
    }*/

    @GetMapping("/{accountNumber}")
    Account getAccount(@PathVariable("accountNumber") String accountNumber);
    @PostMapping("/updateBalance")
    void updateBalance(@RequestBody Account account);

}
