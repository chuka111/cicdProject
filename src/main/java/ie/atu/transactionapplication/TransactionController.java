package ie.atu.transactionapplication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Transfer amount from one account to another
    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestParam Long fromAccount,   // Change String to Long
                                           @RequestParam Long toAccount,   // Change String to Long
                                           @RequestParam Double amount) {
        try {
            transactionService.transfer(fromAccount, toAccount, amount);
            return ResponseEntity.ok("Transfer successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
