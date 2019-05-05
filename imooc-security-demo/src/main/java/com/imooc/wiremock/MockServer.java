package com.imooc.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class MockServer {
    public static void main(String[] args) throws Exception {
        WireMock.configureFor(8082);
        WireMock.removeAllMappings();

//        mock("/order/1", "1");

        ClassPathResource resource = new ClassPathResource("D:\\IdeaProjects\\git\\mysecurity\\imooc-security-demo\\src\\main\\resources\\mock\\response\\1.txt");
        String content = FileUtils.readFileToString(resource.getFile(), "UTF-8");
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/order/1"))
                .willReturn(WireMock.aResponse().withBody(content).withStatus(200)));
    }

    public static void mock(String url, String filename) throws IOException {
        ClassPathResource resource = new ClassPathResource("D:\\IdeaProjects\\git\\mysecurity\\imooc-security-demo\\src\\main\\resources\\mock\\response\\" + filename + ".txt");
        String content = FileUtils.readFileToString(resource.getFile(), "UTF-8");
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(url))
                .willReturn(WireMock.aResponse().withBody(content).withStatus(200)));
    }
}
