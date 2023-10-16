package com.anilerc.healthify.controllers;

import com.anilerc.healthify.models.Billing;
import com.anilerc.healthify.models.Doctor;
import com.anilerc.healthify.requests.CreateBillingRequest;
import com.anilerc.healthify.services.BillingService;
import jdk.javadoc.doclet.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billings")
public class BillingController {

    private final BillingService billingService;

    @Autowired
    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Billing>> getBillings() {
        List<Billing> billings = billingService.findAll();
        return new ResponseEntity<>(billings, HttpStatus.OK);
    }

    public ResponseEntity<Page<Billing>> getBillings(@RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<Billing> billingPages = billingService.findAllPaginated(pageNumber, pageSize);
        return new ResponseEntity<>(billingPages, HttpStatus.OK);
    }

    @GetMapping("/{billingId}")
    public ResponseEntity<Billing> getBilling(@PathVariable Long billingId) {
        Billing billing = billingService.findById(billingId);
        return new ResponseEntity<>(billing, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Billing> createBilling(@RequestBody Billing billing) {
        billingService.save(billing);
        return new ResponseEntity<>(billing, HttpStatus.CREATED);
    }
}
