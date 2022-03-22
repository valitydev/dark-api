package dev.vality.dark.api.service;

import com.github.benmanes.caffeine.cache.Cache;
import dev.vality.damsel.domain.Currency;
import dev.vality.damsel.domain.CurrencyRef;
import dev.vality.damsel.domain.Reference;
import dev.vality.damsel.domain_config.Head;
import dev.vality.damsel.domain_config.RepositoryClientSrv;
import dev.vality.damsel.domain_config.VersionedObject;
import lombok.RequiredArgsConstructor;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DominantService {

    private final Cache<String, Currency> dominantCache;

    private final RepositoryClientSrv.Iface dominantClient;

    public Currency getCurrency(String symbolicCode) {
        return dominantCache.get(symbolicCode, this::getCurrencyFromDominant);
    }

    private Currency getCurrencyFromDominant(String symbolicCode) {
        try {
            final CurrencyRef currencyRef = new CurrencyRef(symbolicCode);
            final VersionedObject versionedObject = dominantClient.checkoutObject(
                    dev.vality.damsel.domain_config.Reference.head(new Head()),
                    Reference.currency(currencyRef));
            return versionedObject.getObject().getCurrency().getData();
        } catch (TException e) {
            throw new CurrencyNotFound(symbolicCode);
        }
    }

}
