package war.webapp.config;


import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;
import org.eurekaclinical.common.config.InjectorSupport;
import war.webapp.props.WebappProperties;

import javax.servlet.ServletContextEvent;
import java.util.ResourceBundle;

/**
 * Created by akalsan on 9/20/16.
 *  Loaded up on application initialization, sets up the application with Guice
 * injector and any other bootup processes.
 */
public class ContextListener extends GuiceServletContextListener {

    private InjectorSupport injectorSupport;
    private static final ResourceBundle projectNameProperty = ResourceBundle.getBundle("main");
    private WebappProperties properties = new WebappProperties();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        super.contextInitialized(servletContextEvent);
        servletContextEvent.getServletContext().setAttribute(
                "webAppProperties", this.properties);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        super.contextDestroyed(servletContextEvent);
        servletContextEvent.getServletContext().removeAttribute(
                "webAppProperties");
    }

    @Override
    protected Injector getInjector() {
        /*
         * Must be created here in order for the modules to initialize
         * correctly.
         */
        if (this.injectorSupport == null) {
            this.injectorSupport = new InjectorSupport(
                    new Module[]{
                        new AppModule(this.properties),
                        new ServletModule(this.properties),},
                    this.properties);
        }
        return this.injectorSupport.getInjector();
    }
}


