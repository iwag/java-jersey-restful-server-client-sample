package io.github.iwag.jerseystarter;

import io.github.iwag.jerseystarter.managers.APIManager;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class TaskTest extends Mockito {
    @Test
    public void testNormal() {
        Assert.assertEquals(APIManager.getUser(), "aaa");
    }
}
