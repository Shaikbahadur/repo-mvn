package war.webapp.config;


import org.eurekaclinical.common.config.AbstractServletModule;
import org.eurekaclinical.common.servlet.DestroySessionServlet;
import org.eurekaclinical.common.servlet.PostMessageLoginServlet;
import org.eurekaclinical.common.servlet.ProxyServlet;
import war.webapp.props.WebappProperties;
import war.webapp.servlet.ViewSampleServlet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akalsan on 9/15/16.
 */
public class ServletModule extends AbstractServletModule {

    private final WebappProperties properties;

    public ServletModule(WebappProperties inProperties) {
        super(inProperties);
        this.properties = inProperties;
    }

    @Override
    protected void setupServlets() {
        serve("/protected/view").with(ViewSampleServlet.class);
        serve("/protected/get-session").with(PostMessageLoginServlet.class);
        serve("/proxy-resource/*").with(ProxyServlet.class);
        serve("/destroy-session").with(DestroySessionServlet.class);
    }

    @Override
    protected Map<String, String> getCasValidationFilterInitParams() {
        Map<String, String> params = new HashMap<>();
        params.put("casServerUrlPrefix", this.properties.getCasUrl());
        params.put("serverName", this.properties.getProxyCallbackServer());
        params.put("proxyCallbackUrl", getCasProxyCallbackUrl());
        params.put("proxyReceptorUrl", getCasProxyCallbackPath());
        return params;
    }
}
