package dev.vality.dark.api.config;

import dev.vality.damsel.domain_config.RepositoryClientSrv;
import dev.vality.damsel.merch_stat.DarkMessiahStatisticsSrv;
import dev.vality.damsel.message_sender.MessageSenderSrv;
import dev.vality.damsel.messages.MessageServiceSrv;
import dev.vality.damsel.payment_processing.PartyManagementSrv;
import dev.vality.damsel.questionary_proxy_aggr.QuestionaryAggrProxyHandlerSrv;
import dev.vality.dark.api.config.property.ConversationProperties;
import dev.vality.dark.api.config.property.QuestionaryAggrProxyProperties;
import dev.vality.file.storage.FileStorageSrv;
import dev.vality.woody.thrift.impl.http.THSpawnClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Slf4j
@Configuration
public class ClientConfig {

    @Value("${http.timeout.read}")
    public Long readTimeoutSec;

    @Value("${http.timeout.connect}")
    public Long connectTimeoutSec;

    @Bean
    @Primary
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.of(connectTimeoutSec, ChronoUnit.SECONDS))
                .setReadTimeout(Duration.of(readTimeoutSec, ChronoUnit.SECONDS))
                .build();
    }

    @Bean
    public FileStorageSrv.Iface fileStorageClient(@Value("${filestorage.client.adapter.url}") Resource resource,
                                                  @Value("${filestorage.client.adapter.networkTimeout}") int timeout)
            throws IOException {
        return new THSpawnClientBuilder()
                .withAddress(resource.getURI())
                .withNetworkTimeout(timeout)
                .build(FileStorageSrv.Iface.class);
    }

    @Bean
    public MessageServiceSrv.Iface messageServiceClient(ConversationProperties conversationProperties)
            throws IOException {
        return new THSpawnClientBuilder()
                .withAddress(conversationProperties.getUrl().getURI())
                .withNetworkTimeout(conversationProperties.getNetworkTimeout())
                .build(MessageServiceSrv.Iface.class);

    }

    @Bean
    public PartyManagementSrv.Iface partyManagementClient(@Value("${partyManagement.url}") Resource resource,
                                                          @Value("${partyManagement.timeout}") int timeout)
            throws IOException {
        return new THSpawnClientBuilder()
                .withAddress(resource.getURI())
                .withNetworkTimeout(timeout)
                .build(PartyManagementSrv.Iface.class);
    }

    @Bean
    public QuestionaryAggrProxyHandlerSrv.Iface questionaryAggrProxyClient(
            QuestionaryAggrProxyProperties questionaryAggrProxyProperties) throws IOException {
        return new THSpawnClientBuilder()
                .withAddress(questionaryAggrProxyProperties.getUrl().getURI())
                .withNetworkTimeout(questionaryAggrProxyProperties.getNetworkTimeout())
                .build(QuestionaryAggrProxyHandlerSrv.Iface.class);

    }

}
