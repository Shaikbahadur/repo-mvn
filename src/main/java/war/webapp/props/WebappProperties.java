package war.webapp.props;


import org.eurekaclinical.standardapis.props.CasEurekaClinicalProperties;

/**
 * Created by akalsan on 9/15/16.
 */
public class WebappProperties extends CasEurekaClinicalProperties {

    public String getServiceUrl() {
        return getValue("bbb.service.url");
    }

    public String getUrl() {
        return getValue("bbb.webapp.url");
    }

    public WebappProperties(String projectName) {
        super("/etc/" + projectName);

    }

    @Override
    public String getProxyCallbackServer() {
        return getValue("bbb.webapp.callbackserver");
    }
}
