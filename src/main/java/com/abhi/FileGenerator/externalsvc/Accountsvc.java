package com.abhi.FileGenerator.externalsvc;

import com.abhi.FileGenerator.vo.AccountDTO;
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
public class Accountsvc {
    @Autowired
    private WebClient.Builder webClientBuilder;
    private URI uri;

    public Accountsvc() {
        uri = UriComponentsBuilder.fromHttpUrl("http://localhost:9010/accounts").build().toUri();

    }

    public List<AccountDTO> getAccounts() {
        WebClient webClient = webClientBuilder.build();

        List<AccountDTO> accountDTOList = webClient.get()
                .uri(uri)
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
        log.info("List of accounts size:" + accountDTOList.size());
        log.info(accountDTOList.toString());
        return accountDTOList;
    }
}
