package com.lee.crm.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.json.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @CreateAuthor: KingIsHappy
 * @CreateDate: 2018/4/28
 * @Description:
 */
public class BaseAction extends ActionSupport implements RequestAware, SessionAware, ApplicationAware {


    // 封装了Request中的参数
    private Map<String, Object> mRequest;
    // 封装了Session中的参数
    private Map<String, Object> mSession;
    // 封装了ServletContext中的参数
    private Map<String, Object> mApplication;

    protected void writeToResponse(Object object) {
        try {
            Gson gson = new Gson();
            String jsonStr = gson.toJson(object);
            ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
            PrintWriter writer = ServletActionContext.getResponse().getWriter();
            writer.write(jsonStr);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setApplication(Map<String, Object> application) {
        this.mApplication = application;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.mRequest = request;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.mSession = session;
    }

    public Map<String, Object> getRequest() {
        return mRequest;
    }

    public Map<String, Object> getSession() {
        return mSession;
    }

    public Map<String, Object> getApplication() {
        return mApplication;
    }
}
