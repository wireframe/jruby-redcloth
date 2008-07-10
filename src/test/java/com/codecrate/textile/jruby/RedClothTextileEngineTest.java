package com.codecrate.textile.jruby;

import junit.framework.TestCase;

public class RedClothTextileEngineTest extends TestCase {
    public void testBasicTextile() {
        RedClothTextileEngine redCloth = new RedClothTextileEngine();
        assertEquals("<p>abc</p>", redCloth.convertToHtml("abc"));
    }
}
