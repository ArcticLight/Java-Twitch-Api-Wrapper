package com.mb3364.twitch.tests;

import com.mb3364.http.RequestParams;
import com.mb3364.twitch.api.Twitch;
import com.mb3364.twitch.api.handlers.ChannelsResponseHandler;
import com.mb3364.twitch.api.handlers.GamesResponseHandler;
import com.mb3364.twitch.api.handlers.StreamsResponseHandler;
import com.mb3364.twitch.api.models.Channel;
import com.mb3364.twitch.api.models.Game;
import com.mb3364.twitch.api.models.Stream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SearchTests {

    private final static String CLIENT_ID = "3ecse7kg5j1tmagtkmzzyxqmvtw1lze";
    private final static String AUTH_TOKEN = "9z2ompq3y9zwx58emz6u9w86mn477s";

    private Twitch client;

    @Before
    public void before() {
        client = new Twitch();
        client.setClientId(CLIENT_ID);
        client.auth().setAccessToken(AUTH_TOKEN);
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test
    public void channelsTest() {
        RequestParams params = new RequestParams();
        params.put("limit", "1");

        client.search().channels("lirik", params, new ChannelsResponseHandler() {
            @Override
            public void onSuccess(int total, List<Channel> channels) {
                System.out.println("Success");
                System.out.println(total);
                System.out.println(channels);
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                System.out.println(statusCode);
                System.out.println(statusMessage);
                System.out.println(errorMessage);
            }

            @Override
            public void onFailure(Throwable e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void streamsTest() {
        RequestParams params = new RequestParams();
        params.put("limit", "1");

        client.search().streams("starcraft", params, new StreamsResponseHandler() {
            @Override
            public void onSuccess(int total, List<Stream> streams) {
                System.out.println("Success");
                System.out.println(total);
                System.out.println(streams);
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                System.out.println(statusCode);
                System.out.println(statusMessage);
                System.out.println(errorMessage);
            }

            @Override
            public void onFailure(Throwable e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void gamesTest() {
        RequestParams params = new RequestParams();
        params.put("live", "true");

        client.search().games("starcraft", params, new GamesResponseHandler() {
            @Override
            public void onSuccess(int total, List<Game> games) {
                System.out.println("Success");
                System.out.println(total);
                System.out.println(games);
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                System.out.println(statusCode);
                System.out.println(statusMessage);
                System.out.println(errorMessage);
            }

            @Override
            public void onFailure(Throwable e) {
                e.printStackTrace();
            }
        });
    }
}