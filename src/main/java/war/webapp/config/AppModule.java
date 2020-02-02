package war.webapp.config;

import war.client.WebappRouterTable;
import war.webapp.props.WebappProperties;
import com.google.inject.AbstractModule;
import org.eurekaclinical.common.comm.clients.RouterTable;
import org.eurekaclinical.standardapis.props.CasEurekaClinicalProperties;

/**
 * Created by akalsan on 9/15/16.
 */
public class AppModule extends AbstractModule {

    private final WebappProperties properties;
    private final Client client;

    public AppModule(WebappProperties inProperties) {
        this.properties = inProperties;
        this.client = new Client(this.properties.getServiceUrl());
    }

    @Override
    protected void configure() {
        bind(RouterTable.class).to(WebappRouterTable.class);
        bind(CasEurekaClinicalProperties.class).toInstance(this.properties);
        bind(Client.class).toInstance(this.client);

    }
}
