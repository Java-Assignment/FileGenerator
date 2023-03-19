package com.abhi.FileGenerator.externalsvc.accountrefsvc;

import com.abhi.FileGenerator.externalsvc.accountrefsvc.dto.AccountDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

@Component
@Slf4j
public class AccountRefSvc {
    @Autowired
    private WebClient.Builder webClientBuilder;
    private URI uri;

    public AccountRefSvc() {
        uri = UriComponentsBuilder.fromHttpUrl("http://localhost:9008/accounts/").build().toUri();
    }

    public List<AccountDTO> getAccounts() {
        WebClient webClient = webClientBuilder.build();

        List<AccountDTO> accountDTOList = webClient.get()
                .exchangeToFlux(
                        response -> {
                            if (response.statusCode().is2xxSuccessful()) {
                                return response.bodyToFlux(AccountDTO.class);
                            } else {
                                return response.createException().flatMapMany(Mono::error);
                            }
                        }
                )
                .collectList()
                .block();
        log.info("AccountSvcWebClient GET AC size:" + accountDTOList.size());
        return accountDTOList;
    }

}
