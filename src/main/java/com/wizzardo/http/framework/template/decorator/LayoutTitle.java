package com.wizzardo.http.framework.template.decorator;

import com.wizzardo.http.framework.template.Decorator;
import com.wizzardo.tools.xml.Node;

/**
 * Created by wizzardo on 30.05.15.
 */
public class LayoutTitle implements Decorator {
    @Override
    public void decorate(Node from, Node to) {
        Node title = from.get("html/head/title");
        if (title != null)
            title.parent().children().remove(title);

        replace(to.find("g:layoutTitle"), title);
    }

    @Override
    public int priority() {
        return 1;
    }
}
