package com.theinternet.tests;

import com.theinternet.core.TestBase;
import com.theinternet.pages.FramesPage;
import com.theinternet.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FramesTests extends TestBase {

    @BeforeEach
    public void preconditions() {
        new HomePage().openFramesPage();
    }

    @ParameterizedTest
    @ValueSource(strings = {"frame-left","frame-middle","frame-right"})
    public void nestedFramesFramesetTest(String frameName){
        FramesPage framesPage = new FramesPage();
        framesPage.openNestedFrames()
                .switchToNestedFrame(frameName);
       Assertions.assertEquals(frameName.substring(6).toUpperCase(),framesPage.getFrameTitle());
    }

    @ParameterizedTest
    @ValueSource(strings = {"frame-bottom"})
    public void nestedFramesTest(String frameName){
        FramesPage framesPage = new FramesPage();
        framesPage.openNestedFrames()
                .switchToFrame(frameName);
       Assertions.assertEquals(frameName.substring(6).toUpperCase(),framesPage.getFrameTitle());
    }

    @Test
    public void iframesTest(){
        FramesPage framesPage = new FramesPage();
        framesPage.openIframes()
                .closeAlert()
                .switchToIframe();
       Assertions.assertEquals("Your content goes here.",framesPage.getFrameTitle());
    }
}
