package org.tc.appsvr.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author tc
 * @since 2019-11-14
 */
public class ParameterRequestWrapper extends HttpServletRequestWrapper {


    public ParameterRequestWrapper(HttpServletRequest request ) {
        super(request);

    }

    @Override
    public String getParameter(String name) {
       return (String) super.getAttribute(name);
    }
}
