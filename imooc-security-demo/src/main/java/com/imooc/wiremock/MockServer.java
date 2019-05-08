package com.imooc.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class MockServer {
//    public static void main(String[] args) throws Exception {
//        WireMock.configureFor(8082);
//        WireMock.removeAllMappings();
//
//        mock("/order/1", "1");
//    }

    public static void mock(String url, String filename) throws IOException {
        File file = new File("D:\\IdeaProjects\\git\\mysecurity\\imooc-security-demo\\src\\main\\resources\\mock\\response\\" + filename + ".txt");
        String content = FileUtils.readFileToString(file, "UTF-8");
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(url))
                .willReturn(WireMock.aResponse().withBody(content).withStatus(200)));
    }
}
