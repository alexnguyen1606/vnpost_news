package com.vnpost.customtag;

import com.vnpost.customtag.annotation.Bookmark;
import lombok.Getter;
import lombok.Setter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.lang.reflect.Field;

@Getter
@Setter
public class BookmarkTag extends TagSupport {
    private String fieldName;
    private String objectName;

    @Override
    public int doStartTag() throws JspException {
        try {
            Object object = pageContext.getRequest().getAttribute(objectName);
            Class<?> clazz = object.getClass();
            Field field = clazz.getDeclaredField(fieldName);
            if (field.isAnnotationPresent(Bookmark.class)) {
                Bookmark labelLookup = field.getAnnotation(Bookmark.class);
                JspWriter out = pageContext.getOut();
                out.print(labelLookup.value());
            }
        } catch (NoSuchFieldException | IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
