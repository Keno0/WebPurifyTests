import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class WebPurifyTests {

    WebPurify webPurify;
    boolean isItTrueTest = false;
    String word = "English";

    @Before
    public void SetUpTest()
    {
        webPurify = new WebPurify();
    }

    @Test
    public void CheckMethodNotFoundBlackListWordTest() throws IOException {
        isItTrueTest = !webPurify.Check("This text is good.");
    }

    @Test
    public void CheckMethodFoundBlackListWordTest() throws IOException {
        isItTrueTest = webPurify.Check("This text is shit.");
    }

    @Test
    public void AddToBlackListIfNotContainTest() throws IOException {


        if(!webPurify.Check(word))
        {
            webPurify.AddToBlack(word);
            isItTrueTest = webPurify.Check(word);
        }
        else
        {
            isItTrueTest = true;
        }
    }

    @Test
    public void RemoveFromBlackListIfContainTest() throws IOException{

        if(webPurify.Check(word))
        {
            webPurify.RemoveFromBlack(word);
            isItTrueTest = !webPurify.Check(word);
        }
        else
        {
            isItTrueTest=true;
        }
    }

    @After
    public void EvaluateTestResult()
    {
        Assert.assertTrue(isItTrueTest);
    }
}
