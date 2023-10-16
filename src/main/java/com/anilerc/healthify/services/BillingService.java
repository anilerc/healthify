package com.anilerc.healthify.services;

import com.anilerc.healthify.models.Billing;
import com.anilerc.healthify.models.Patient;
import com.anilerc.healthify.repositories.BillingRepository;
import org.springframework.stereotype.Service;

@Service
public class BillingService extends GenericService<Billing>{

    private final BillingRepository repo;

    public BillingService(BillingRepository repo) {
        super(repo);
        this.repo = repo;
    }

    public Boolean hasUnpaidBilling(Patient p) {
        return repo.countUnpaidBillingRecords(p.getId()) != 0;
    }

    public void save(Billing billing) {
        repo.save(billing);
    }
}
