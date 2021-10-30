package app.dummy_service.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import core.framework.http.HTTPClient;
import core.framework.http.HTTPClientBuilder;
import core.framework.impl.module.ModuleContext;
import core.framework.impl.web.bean.RequestBeanMapper;
import core.framework.impl.web.bean.ResponseBeanMapper;
import core.framework.impl.web.service.WebServiceClient;
import core.framework.impl.web.service.WebServiceClientBuilder;
import core.framework.impl.web.service.WebServiceInterfaceValidator;
import core.framework.module.APIConfig;

/**
 * Created by Chef.Xie on 2021-10-30
 */
public class ClientMapper {
    private final Logger logger = LoggerFactory.getLogger(APIConfig.class);
    private final ModuleContext context = new ModuleContext();
    private final HTTPClient httpClient;

    {
        // refer to: kube graceful shutdown period is 30s, db timeout is 15s
        HTTPClientBuilder httpClientBuilder = new HTTPClientBuilder()
                .userAgent(WebServiceClient.USER_AGENT)
                .trustAll()
                .connectTimeout(Duration.ofSeconds(2))
                .timeout(Duration.ofSeconds(20)) // refer to: kube graceful shutdown period is 30s, db timeout is 15s
                .slowOperationThreshold(Duration.ofSeconds(10))
                .maxRetries(5);
        httpClient = httpClientBuilder.build();
    }

    public <T> T client(Class<T> serviceInterface, String serviceURL) {
        logger.info("create web service client, interface={}, serviceURL={}", serviceInterface.getCanonicalName(),
                    serviceURL);
        RequestBeanMapper requestBeanMapper = context.httpServer.handler.requestBeanMapper;
        ResponseBeanMapper responseBeanMapper = context.httpServer.handler.responseBeanMapper;
        new WebServiceInterfaceValidator(serviceInterface, requestBeanMapper, responseBeanMapper,
                                         context.beanClassNameValidator).validate();

        //TODO add interceptor to handle failure, so we could assert failure statusCode and message
        var webServiceClient = new WebServiceClient(serviceURL, httpClient, requestBeanMapper, responseBeanMapper);
        T client = createWebServiceClient(serviceInterface, webServiceClient);
        context.beanFactory.bind(serviceInterface, null, client);
        return client;
    }

    private <T> T createWebServiceClient(Class<T> serviceInterface, WebServiceClient webServiceClient) {
        return new WebServiceClientBuilder<>(serviceInterface, webServiceClient).build();
    }
}
