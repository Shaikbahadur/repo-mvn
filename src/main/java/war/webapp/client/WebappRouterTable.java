package war.webapp.client;

import org.eurekaclinical.common.comm.clients.Route;
import org.eurekaclinical.common.comm.clients.RouterTable;
import war.client.Client;

import javax.inject.Inject;

/**
 * Created by akalsan on 9/15/16.
 */
public class WebappRouterTable implements RouterTable {

    private final Client client;

    @Inject
    public ServiceClientRouterTable(Client inClient) {
        this.client = inClient;
    }

    @Override
    public Route[] load() {
        return new Route[]{new Route("/", "/api/protected/", this.client)};
    }

}
