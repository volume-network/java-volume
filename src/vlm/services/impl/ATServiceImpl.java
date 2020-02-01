package vlm.services.impl;

import vlm.AT;
import vlm.db.store.ATStore;
import vlm.services.ATService;

import java.util.Collection;
import java.util.List;

public class ATServiceImpl implements ATService {

    private final ATStore atStore;

    public ATServiceImpl(ATStore atStore) {
        this.atStore = atStore;
    }

    @Override
    public Collection<Long> getAllATIds() {
        return atStore.getAllATIds();
    }

    @Override
    public List<Long> getATsIssuedBy(Long accountId) {
        return atStore.getATsIssuedBy(accountId);
    }

    @Override
    public AT getAT(Long id) {
        return atStore.getAT(id);
    }

}
