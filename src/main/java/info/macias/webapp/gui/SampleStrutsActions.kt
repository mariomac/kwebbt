package info.macias.webapp.gui

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ActionContext
import com.opensymphony.xwork2.ActionSupport
import java.util.*

class ChangeLangAction : ActionSupport() {
    var lang: String? = null

    @Throws(Exception::class)
    override fun execute(): String {
        val locale = Locale(lang)
        ActionContext.getContext().session.put("WW_TRANS_I18N_LOCALE", locale)
        return com.opensymphony.xwork2.Action.SUCCESS
    }
}

class Demo : ActionSupport() {
    var number: Int = 0

    @Throws(Exception::class)
    override fun execute(): String {
        if (number == null || number < 10 || number > 20) {
            // this is not needed, since this validation is performed in demo-validation.xml
            addFieldError("number", getText("demo.error"))
            return Action.INPUT
        }
        return Action.SUCCESS
    }
}

class Index : ActionSupport() {
    @Throws(Exception::class)
    override fun execute(): String {
        return Action.SUCCESS
    }
}