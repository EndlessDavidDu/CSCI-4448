package com.wy.tool;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.RequestProcessor;

/**
 * self-define RequestProcessor
 */
public class SelfRequestProcessor extends RequestProcessor {
    public SelfRequestProcessor() {
    }

    @Override
    protected boolean processPreprocess(HttpServletRequest request,
                                        HttpServletResponse response) {
        super.processPreprocess(request, response);
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        return true;
    }
}
