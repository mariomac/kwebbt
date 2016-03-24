package info.macias.webapp.gui;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.mapper.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class ChangeLangAction extends ActionSupport {
    private String lang;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String execute() throws Exception {
        Locale locale = new Locale(lang);
        ActionContext.getContext().getSession().put("WW_TRANS_I18N_LOCALE", locale);
        return SUCCESS;
    }
}
