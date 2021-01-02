package com.company.facebook;

import com.company.api.open.handler.CustomHttpHandlerCommand;
import com.company.api.search.DataEntity;
import com.company.api.search.DataTable;
import com.company.api.search.SearchEngine;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.util.Map;

public class WebHook implements CustomHttpHandlerCommand {
    private int counter = 0;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        counter++;
        System.out.println(" ---- got /hello request    counter = " + counter);
        final StringBuilder responseBuilder = new StringBuilder();
        int responseCode = 405;

        if (exchange.getRequestMethod().equals("GET")) {

            Map<String, String> paramByKey = splitQuery(exchange.getRequestURI().getRawQuery());


            System.out.println("params ::");
            paramByKey.forEach((a, b) -> {
                System.out.println(" key = " + a + " val = " + b);
            });

//            if (paramByKey.containsKey("q")) {
//                responseCode = 200;
//                final String query = paramByKey.get("q");
//
//                SearchEngine searchEngine = searchEngineList.get(0);
//                DataTable dataTable = searchEngine.search(query);
//                for (int i = 0; i < searchEngineList.size(); i++) {
//                    searchEngine = searchEngineList.get(i);
//                    dataTable = searchEngine.search(query);
//                    if (dataTable.getEntityNumber() > 1)
//                        break;
//                }
//
//                for (int i = 0; i < dataTable.getEntityNumber(); i++) {
//                    DataEntity dataEntity = dataTable.getEntity(i);
//                    responseBuilder
//                            .append("<h3>")
//                            .append(dataEntity.getTitle())
//                            .append("</h3>")
//                            .append(dataEntity.getOverview())
//                            .append("<br/>")
//                            .append("<a href=\"")
//                            .append(dataEntity.getUrl())
//                            .append("\">")
//                            .append(dataEntity.getUrl())
//                            .append("</a>")
//                            .append("<br/><br/>");
//                }
//            }
        }
        if (responseCode == 405) {
            responseBuilder.append("Wrong method usage. Use /help");
        }

        endResponse(exchange, responseBuilder.toString(), responseCode);

    }
}