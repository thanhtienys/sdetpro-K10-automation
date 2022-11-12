package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PageHelper {

    private final JavascriptExecutor javascriptExecutor;
    private static final String SCROLL_TO_BOTTOM = "window.scroll(0,document.body.scrollHeight)";
    private static final String SCROLL_TO_TOP = "window.scroll(document.body.scrollHeight,0)";

    public PageHelper(JavascriptExecutor javascriptExecutor) {
        this.javascriptExecutor = javascriptExecutor;
    }

    public void scrollToBottom(){
        javascriptExecutor.executeScript(SCROLL_TO_BOTTOM);
    }

    public void scrollToTop(){
        javascriptExecutor.executeScript(SCROLL_TO_TOP);
    }

    public void removeElem(WebElement element){
        javascriptExecutor.executeScript("arguments[0].remove()",element);

    }

    public void changeElemStyleToFocusMode(WebElement element){
        // TODO: to be continue for custom style
        javascriptExecutor.executeScript("arguments[0].setAttribute('style','background:blue; broder: 4px solid red;')", element);
    }

    public void changeElemStyleToFocusMode(WebElement element, String customStyle){
        // TODO: to be continue for custom style
    }
}

