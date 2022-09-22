package com.vnpost.customtag;

import com.vnpost.customtag.annotation.Name;
import lombok.Getter;
import lombok.Setter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.lang.reflect.Field;
@Setter
@Getter
public class NameTag extends TagSupport {
    private String fieldName;
    private String objectName;

    @Override
    public int doStartTag() throws JspException {
        try {
            Object object = pageContext.getRequest().getAttribute(objectName);
            Class<?> clazz = object.getClass();
            Field field = clazz.getDeclaredField(fieldName);
            if (field.isAnnotationPresent(Name.class)) {
                Name labelLookup = field.getAnnotation(Name.class);
                JspWriter out = pageContext.getOut();
                out.print(labelLookup.value());
            }
        } catch (NoSuchFieldException | IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}


