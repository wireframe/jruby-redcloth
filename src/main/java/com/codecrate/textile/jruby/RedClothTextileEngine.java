package com.codecrate.textile.jruby;

import com.codecrate.textile.TextileEngine;

import java.io.Serializable;
import java.util.Collections;

import org.jruby.Ruby;
import org.jruby.javasupport.JavaEmbedUtils;
import org.jruby.runtime.builtin.IRubyObject;

public class RedClothTextileEngine implements TextileEngine, Serializable {
    private transient Ruby ruby;

    public synchronized String convertToHtml(String input) {
        Ruby runtime = getRuntime();
        
        runtime.defineReadonlyVariable("$text", JavaEmbedUtils.javaToRuby(ruby, input));
        IRubyObject result = runtime.evalScript("RedCloth.new($text).to_html");

        return result.toString();
    }
    
    private Ruby getRuntime() {
        if (ruby == null) {
            ruby = JavaEmbedUtils.initialize(Collections.EMPTY_LIST);

            ruby.getLoadService().require("redcloth");
            ruby.getLoadService().require("redcloth_java_integration");
        }
        return ruby;
    }
}
