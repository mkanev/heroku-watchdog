package io.github.mkanev.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import io.github.mkanev.common.LoggedClass;

/**
 * @author <a href="mailto:maksim.kanev@waveaccess.ru">Maksim Kanev</a>
 */
public class WatchUnit extends LoggedClass implements Runnable {

    private static final String USER_AGENT = "Mozilla/5.0";

    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet("http://agile-anchorage-3289.herokuapp.com/rest/compliment/random");
            request.setHeader("Host", "agile-anchorage-3289.herokuapp.com");
            request.setHeader("User-Agent", USER_AGENT);
            request.setHeader("Accept", "*/*");
            request.setHeader("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4");
            request.setHeader("Accept-Charset", "utf-8");
            request.setHeader("Connection", "keep-alive");
            request.setHeader("Referer", "http://agile-anchorage-3289.herokuapp.com");
//            request.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            /*HttpResponse response = */httpClient.execute(request);
//            String msg = EntityUtils.toString(response.getEntity());
            logDebug("Response received in %d ms", System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            logError(e);
        }
    }
}
